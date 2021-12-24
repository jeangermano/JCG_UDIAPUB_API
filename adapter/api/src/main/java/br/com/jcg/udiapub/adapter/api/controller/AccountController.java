package br.com.jcg.udiapub.adapter.api.controller;

//import br.com.jcg.studies.account.application.port.in.AccountRegister;
//import br.com.jcg.studies.account.application.port.in.request.MainAccountRequestModel;
//import br.com.jcg.studies.account.application.port.in.response.AccountResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {

//    AccountRegister accountRegister;
//
//    @PostMapping
//    public AccountResponseModel accountRegister(MainAccountRequestModel mainAccountRequestModel) {
//        return this.accountRegister.mainAccount(mainAccountRequestModel);
//    }

    @GetMapping
    public String doYouHearMe(){
        return "I Hear you 🥰";
    }
}
