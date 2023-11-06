def classify_ip(ip):
    try:
        # Split the IP address into octets
        octets = ip.split('.')
        
        if len(octets) == 4:
            first_octet = int(octets[0])
            
            if 1 <= first_octet <= 126:
                return "Class A"
            elif 128 <= first_octet <= 191:
                return "Class B"
            elif 192 <= first_octet <= 223:
                return "Class C"
            elif 224 <= first_octet <= 239:
                return "Class D"
            elif 240 <= first_octet <= 255:
                return "Class E"
            else:
                return "Invalid IP Address"
        else:
            return "Invalid IP Address"
    except ValueError:
        return "Invalid IP Address"

# Example usage
ip = "192.168.1.1"  # Replace with the IP address you want to classify
classification = classify_ip(ip)
print(f"IP: {ip} is a {classification}")
