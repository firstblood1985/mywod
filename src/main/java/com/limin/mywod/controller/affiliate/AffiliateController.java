package com.limin.mywod.controller.affiliate;


import com.limin.mywod.entity.affiliate.Affiliate;
import com.limin.mywod.entity.affiliate.repository.AffiliateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/affiliate")
public class AffiliateController {
    @Autowired
    private AffiliateRepository affiliateRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Affiliate> getAllUsers(){

        return (List<Affiliate>) this.affiliateRepository.findAll();
    }
}
