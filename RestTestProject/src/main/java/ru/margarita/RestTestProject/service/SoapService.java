package ru.margarita.RestTestProject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


import ru.margarita.RestTestProject.entity.Department;
import ru.margarita.soap.ws.client.generated.Calculator;
import ru.margarita.soap.ws.client.generated.Add;
import ru.margarita.soap.ws.client.generated.AddResponse;

@Service
@RequiredArgsConstructor
public class SoapService extends WebServiceGatewaySupport {

    public Integer calculateSalary (Integer departmentIds) {

//        Calculator calculator = new Calculator();
//        System.out.println( calculator.getCalculatorSoap().add(5,7) );
//
//        AddResponse response = (AddResponse) getWebServiceTemplate()
//                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", calculator);
//        System.out.println(response);

        return 5;
}

}
