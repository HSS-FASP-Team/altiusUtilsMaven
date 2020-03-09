/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cc.altius.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This utility is used to compare an IP to either a range of IP's or another IP
 * @author Akil Mahimwala
 */
public class IPUtils {

    private final long startIP;
    private final long stopIP;

    /**
     * Constructor used to initialize the IPUtils object.
     *
     * @param ipRange Range of IP that is in the allowed list. Should be either
     * a range of IP's in the format "0.0.0.0 - 0.0.0.0" or just one IP in the
     * format "0.0.0.0"
     */
    public IPUtils(String ipRange) {
        if (ipRange.indexOf("-") > 0) {
            String[] ips = ipRange.split("-");
            startIP = ipToLong(ips[0]);
            stopIP = ipToLong(ips[1]);
        } else {
            startIP = ipToLong(ipRange);
            stopIP = 0;
        }
    }

    private long ipToLong(String ip) {
        try {
            InetAddress inet = InetAddress.getByName(ip);
            byte[] octets = inet.getAddress();
            long result = 0;
            for (byte octet : octets) {
                result <<= 8;
                result |= octet & 0xff;
            }
            return result;
        } catch (UnknownHostException u) {
            return 0;
        }
    }

    /**
     * Once the object has been initialized with the range, you can then use
     * this method to check if your IP is within the range.
     *
     * @param ip IP to check must be in the format "0.0.0.0"
     * @return true if it is within the given range and false if not from the
     * range. Returns false if the IP range was not initialized.
     */
    public boolean checkIP(String ip) {
        long ipToTest = ipToLong(ip);
        if (this.stopIP == 0) {
            if (ipToTest == this.startIP) {
                return true;
            } else {
                return false;
            }
        } else if (ipToTest >= this.startIP && ipToTest <= this.stopIP) {
            return true;
        } else {
            return false;
        }
    }

}
