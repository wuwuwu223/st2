public class Triangle {
    private boolean isTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    private boolean isValidInput(int a, int b, int c) {
                return a >= 1 && a <= 100 && b >= 1 && b <= 100 && c >= 1 && c <= 100;
    }

    public String calculateType(int a, int b, int c) {
        String triangleType;
        if (!isValidInput(a, b, c)) {
            triangleType = "输入错误";
        } else if (!isTriangle(a, b, c)) {
            triangleType = "非三角形";
        } else if (a == b && b == c) {
            triangleType = "等边三角形";
        } else if (a == b || a == c || b == c) {
            triangleType = "等腰三角形";
        } else {
            triangleType = "一般三角形";
        }
        return triangleType;
    }
}
