package org.opendaylight.controller.sdni;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class SDNiBandwidth {
		@XmlElement
	    Set<String> bandwidth;
		@XmlElement
		String name;
		
		public SDNiBandwidth() {
			// TODO Auto-generated constructor stub
		}
		public SDNiBandwidth(Set<String> bandwidth, String name) {
            this.bandwidth = bandwidth;
            this.name = name;
	    }
	
	     public Set<String> getBandwidth() {
	            return bandwidth;
	    }
	
	    public void setBandwidth(Set<String> bandwidth) {
	    		this.bandwidth = bandwidth;
	    }
	    
	    public String getName() {
	        return name;
	    }
	
	    public void setName(String name) {
	    		this.name = name;
	    }
}
