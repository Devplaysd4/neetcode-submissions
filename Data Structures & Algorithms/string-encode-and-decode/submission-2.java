class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

    for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
            
    }

    return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
    int i = 0;

    while (i < str.length()) {
        int j = i;
        while(str.charAt(j)!='#'){
            j++;
        }
        int len= Integer.parseInt(str.substring(i,j));
        int start = j+1;
        int end = j+1+len;
        result.add(str.substring(start,end));
        i=end;
        // move j until '#'

        // parse length from i to j

        // actual string starts after '#'
        // actual string ends after start + len

        // extract substring and add to result

        // move i to the start of the next encoded chunk
    }

    return result;
    }
}