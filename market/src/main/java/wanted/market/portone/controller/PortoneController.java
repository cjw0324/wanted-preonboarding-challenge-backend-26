package wanted.market.portone.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import wanted.market.portone.domain.WebHook;
import wanted.market.portone.domain.dto.PurchaseValidationRequest;
import wanted.market.portone.service.PortoneService;

@Slf4j
@RestController
@RequestMapping("/portone")
@RequiredArgsConstructor
public class PortoneController {

    private final PortoneService portoneService;



    @PostMapping("/webhook")
    public void webhook(@RequestBody WebHook webHook) {
        log.info("received : {}, {}, {}, {}", webHook.getImp_uid(), webHook.getMerchant_uid(), webHook.getStatus(), webHook.getCancellation_id());
        portoneService.validateWebHook(webHook);
    }

}