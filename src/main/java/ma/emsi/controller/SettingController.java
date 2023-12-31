package ma.emsi.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.emsi.model.Setting;
import ma.emsi.service.SettingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/setting")
@AllArgsConstructor
public class SettingController {

    private final SettingService settingService;

    @PostMapping
    public ResponseEntity<?> createSetting(@Valid @RequestBody Setting setting) {
        try {
            Setting createdSetting = settingService.createSetting(setting);
            return new ResponseEntity<>(createdSetting, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSettingById(@PathVariable int id) {
        try {
            Setting setting = settingService.getSettingById(id);
            return ResponseEntity.ok(setting);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Setting>> getAllSettings() {
        List<Setting> settings = settingService.getAllSettings();
        return ResponseEntity.ok(settings);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSetting(@PathVariable int id, @Valid @RequestBody Setting updatedSetting) {
        try {
            Setting setting = settingService.updateSetting(id, updatedSetting);
            return ResponseEntity.ok(setting);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSetting(@PathVariable int id) {
        try {
            settingService.deleteSetting(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
