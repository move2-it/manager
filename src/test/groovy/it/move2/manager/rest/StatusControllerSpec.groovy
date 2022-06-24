package it.move2.manager.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import spock.lang.Specification

class StatusControllerSpec extends Specification {

    StatusController statusController

    def setup() {
        statusController = new StatusController()
    }

    def "Should return OK"() {
        given:
        def healthCheckResponse = new ResponseEntity<>("OK", HttpStatus.OK)

        when:
        def result = statusController.healthCheck()

        then:
        healthCheckResponse == result
    }

}
