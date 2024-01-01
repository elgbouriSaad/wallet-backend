package ma.emsi.service;

import ma.emsi.model.User;
import ma.emsi.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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

    @Transactional
    public User registerUser(User user) {
        user.setEmailVerified(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public void verifyEmail(int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
        user.setEmailVerified(true);
        userRepository.save(user);
    }

    public boolean verifyUser(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email,password);

        return user != null && user.isEmailVerified() && passwordEncoder.matches(password, user.getPassword());
    }
}
