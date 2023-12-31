package ma.emsi.controller;

import lombok.AllArgsConstructor;
import ma.emsi.service.SettingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/api/v1/setting")
@RestController
public class SettingController {

    private final SettingService settingService;
}
