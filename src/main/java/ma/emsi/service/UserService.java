package ma.emsi.service;

import jakarta.servlet.http.HttpSession;
import ma.emsi.model.User;
import ma.emsi.repository.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    public UserService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    @Transactional
    public User createUser(User user) {
        // Perform any additional validation/business logic here before saving
        return userRepository.save(user);
    }

    public User getUserById(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User updateUser(int id, User updatedUser) {
        User existingUser = getUserById(id);

        // Perform any additional validation/business logic here before updating
        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setAmount(updatedUser.getAmount());
        existingUser.setDateSalary(updatedUser.getDateSalary());
        existingUser.setSalary(updatedUser.getSalary());
        existingUser.setAccounts(updatedUser.getAccounts());
        existingUser.setSetting(updatedUser.getSetting());

        return userRepository.save(existingUser);
    }

    @Transactional
    public void deleteUser(int id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }

    public void loginUser(User user) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Store user information in the session
        httpSession.setAttribute("user", user);
    }

    public void logoutUser() {
        // Perform logout logic
        SecurityContextHolder.clearContext();

        // Clear user information from the session
        httpSession.removeAttribute("user");
    }

    public User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + email));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                // Add roles or authorities if needed
                Collections.emptyList()
        );
    }
}
