package client.feignclient.utils;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "feignDemo",url = "http://localhost:8080/user")
public interface FeignServiceUtil {
    @GetMapping("/status")
    String getStatus();
    @GetMapping("/address")
    String getAddress();
    @GetMapping("/name")
    String getName();
}
