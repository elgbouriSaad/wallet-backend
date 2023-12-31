package ma.emsi.service;

import ma.emsi.model.Setting;
import ma.emsi.repository.SettingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SettingService {

    private final SettingRepository settingRepository;

    public SettingService(SettingRepository settingRepository) {
        this.settingRepository = settingRepository;
    }

    @Transactional
    public Setting createSetting(Setting setting) {
        // Perform any additional validation/business logic here before saving
        return settingRepository.save(setting);
    }

    public Setting getSettingById(int id) {
        return settingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Setting not found with id: " + id));
    }

    public List<Setting> getAllSettings() {
        return settingRepository.findAll();
    }

    @Transactional
    public Setting updateSetting(int id, Setting updatedSetting) {
        Setting existingSetting = getSettingById(id);

        // Perform any additional validation/business logic here before updating
        existingSetting.setCurrency(updatedSetting.getCurrency());

        return settingRepository.save(existingSetting);
    }

    @Transactional
    public void deleteSetting(int id) {
        Setting setting = getSettingById(id);
        settingRepository.delete(setting);
    }
}
