package com.projectexample.restdemo.service.impl;

import com.projectexample.restdemo.exception.CloudVendorException;
import com.projectexample.restdemo.exception.CloudVendorNotFoundException;
import com.projectexample.restdemo.model.CloudVendor;
import com.projectexample.restdemo.repository.CloudVendorRepository;
import com.projectexample.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CloudVendorServiceImpl implements CloudVendorService
{
    CloudVendorRepository cloudVendorRepository;

    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }


    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {

        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "success";
    }

    @Override
    public String deleteCloudVendor(String VendorId) {

        cloudVendorRepository.deleteById(VendorId);
        return "success";
    }

    @Override
    public CloudVendor getCloudVendor(String VendorId) {
        if(cloudVendorRepository.findById(VendorId).isEmpty())
        {
            throw new CloudVendorNotFoundException("Request Cloud Vendor does not exit");
        }

        return cloudVendorRepository.findById(VendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
