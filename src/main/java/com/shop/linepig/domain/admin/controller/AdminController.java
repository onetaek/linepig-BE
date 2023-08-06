package com.shop.linepig.domain.admin.controller;

import com.shop.linepig.domain.member.dto.response.MemberStatusResponse;
import com.shop.linepig.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdminController {

    private final MemberService memberService;

    @GetMapping("/admins/login")
    public String loginPage() {
        return "/admins/login";
    }

    @GetMapping(value = {"/admins/welcome", "/admins"})
    public String welcomePage() {
        return "/admins/welcome";
    }

    @GetMapping("/admins/products/new")
    public String productNewPage(Model model) {
        model.addAttribute("members", memberService.findAll());
        return "/admins/products/new";
    }

    @GetMapping("/admins/members")
    public String members(Model model) {
        model.addAttribute("members", memberService.findAll());
        model.addAttribute("genders", memberService.getGenders());
        List<MemberStatusResponse> statuses = memberService.getStatuses();
        log.info("statues = {}",statuses);
        model.addAttribute("statuses", statuses);
        return "/admins/members/members";
    }


}
