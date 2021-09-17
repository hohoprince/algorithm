class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        
        Map<String, Integer> map = new HashMap<>();
        
        for (String cpdomain : cpdomains) {
            String[] tmp = cpdomain.split(" ");
            int count = Integer.parseInt(tmp[0]);
            String[] domains = tmp[1].split("\\.");
            
            String domain = "";
            for (int i = domains.length - 1; i >= 0; i--) {
                if (domain.equals("")) {
                    domain = domains[i];
                } else {
                    domain = domains[i] + "."+ domain;
                }
                map.put(domain, map.getOrDefault(domain, 0) + count);
            }
            
        }
        
        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key) + " " + key);
        }
        
        return result;
    }
}
