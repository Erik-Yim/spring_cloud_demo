package com.erik.cloud.demo.user.controller;

import com.erik.cloud.demo.user.entity.User;
import com.erik.cloud.demo.user.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonHystrixController {
  @Autowired
  private RibbonHystrixService ribbonHystrixService;

  @GetMapping("/ribbon/{id}")
  public User findById(@PathVariable Long id) {
    return this.ribbonHystrixService.findById(id);
  }
}
