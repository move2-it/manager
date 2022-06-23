package it.move2.manager

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

@SpringBootTest(classes = ManagerApplication)
class ControllerTestSpec extends Specification {

    RestTemplate restTemplate

    def setup() {
        restTemplate = new RestTemplate()
    }

    def "Should return OK" () {
        when:
        def result = restTemplate.getForEntity("http://127.0.0.1:8082/health-check", String.class)

        then:
        result.statusCode.value() == 200
        result.body.toString() == "OK"
    }
}
