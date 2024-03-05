package com.projectexample.restdemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Cloud_Vendor_Info")
public class CloudVendor {
    @Id
    String VendorId;
    String  VendorName;
    String VendorAddress;
    String VendorPhoneNo;

    public String getVendorId() {
        return VendorId;
    }

    public void setVendorId(String vendorId) {
        VendorId = vendorId;
    }

    public String getVendorName() {
        return VendorName;
    }

    public void setVendorName(String vendorName) {
        VendorName = vendorName;
    }

    public String getVendorAddress() {
        return VendorAddress;
    }

    public void setVendorAddress(String vendorAddress) {
        VendorAddress = vendorAddress;
    }

    public String getVendorPhoneNo() {
        return VendorPhoneNo;
    }

    public void setVendorPhoneNo(String vendorPhoneNo) {
        VendorPhoneNo = vendorPhoneNo;
    }


    public CloudVendor() {
    }


    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhoneNo) {
        VendorId = vendorId;
        VendorName = vendorName;
        VendorAddress = vendorAddress;
        VendorPhoneNo = vendorPhoneNo;
    }



}
