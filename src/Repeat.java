/**
 * ggdsh
 */
public class Repeat {

    /***
     *  nmsf
     * @param line mahlare 
     * @return boolean
     */
    public boolean repeats(String line) {

        int u = 0;
        String temp = "";
        boolean repeat = false;
        // here y is the number o chars between X.
        for (int y = 0; y < line.length(); y++) {
            for (int i = 0; i < line.length(); i++) {
                // index of char just after string y, in string xyx.
                int k = i + y + 1;
                if (k < line.length()) {
                char str = line.charAt(i);
                char tmp = line.charAt(k);
                    if (Character.compare(str, tmp) == 0) {
                        temp = line.substring(i, k + 1);
                        for (int j = i + 1; j < line.length(); j++) {
                            int l = j + y + 1;
                            if (l < line.length()) {
                                if (Character.compare(line.charAt(j), 
                                line.charAt(l)) == 0) {
                                String newString = line.substring(j, l + 1);
                                    if (temp.compareTo(newString) == 0) {
                                        return true;
                                        // u++;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
