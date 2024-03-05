package com.projectexample.restdemo.controller;

import com.projectexample.restdemo.model.CloudVendor;
import com.projectexample.restdemo.service.CloudVendorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorAPIService {
    public CloudVendorAPIService(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    CloudVendorService cloudVendorService;
    @GetMapping("{VendorId}")

    public CloudVendor getCloudVendorDetails(@PathVariable("VendorId") String VendorId)
    {
        return cloudVendorService.getCloudVendor(VendorId);


    }
    @GetMapping
    public List<CloudVendor> getAllCloudVendorDetails()
    {
        return  cloudVendorService.getAllCloudVendor();
    }
    @PostMapping
    public  String CreateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor( cloudVendor);

        return  "cloud vendor created";
    }
    @PutMapping
    public  String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
       cloudVendorService.updateCloudVendor(cloudVendor);
        return  "cloud vendor updated";
    }
    @DeleteMapping
    public  String DeleteCloudVendorDetails(@PathVariable("VendorId") String VendorId)
    {
        cloudVendorService.deleteCloudVendor(VendorId);
        return  "cloud vendor deleted";
    }
}