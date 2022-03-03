package peaksoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import peaksoft.entity.Company;
import peaksoft.sarvice.CompanyService;

import java.util.List;


@Controller
@RequestMapping("/api/companies")
public class CompanyController {

    // Dependency
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @ModelAttribute(name = "companies")
    public List<Company> getAllCompanies() {
        return companyService.getAllCompany();
    }

    @GetMapping
    public String showMainPage() {
        return "main_page";
    }

    @GetMapping("/get/{companyId}")
    public String getCompanyById(@PathVariable Long companyId) {
        // TODO: 02.03.2022 add get company by id
        return "company";
    }

    @GetMapping("/delete/{companyId}")
    public String deleteCompanyById(@PathVariable Long companyId) {
        companyService.deleteByIdCompany(companyId);
        return "delete_success_page";
    }


}
