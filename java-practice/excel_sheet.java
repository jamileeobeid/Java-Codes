//Given an integer columnNumber, we will return its corresponding column title as it appears in an Excel sheet.

class excel_sheet {
    public static String convertToTitle(int cn) {

        StringBuilder builder = new StringBuilder();
        while(cn>0){
            cn--;
            int remainder = cn%26;
            builder.insert(0, (char)(remainder+'A'));
            cn=cn/26;
        }
        return builder.toString();
        
    }

    public static void main(String[] args) {
        
        System.out.println(convertToTitle(1)); //A
        System.out.println(convertToTitle(28)); //AB
        System.out.println(convertToTitle(701)); //ZY
    }
}