import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    private Triangle triangle = new Triangle();

    @Test
    // 一般边界值方法：正常范围内的不同三角形类型测试
    public void testGeneralBoundaryValues() {
        assertEquals("等边三角形", triangle.calculateType(3, 3, 3));
        assertEquals("等腰三角形", triangle.calculateType(3, 3, 4));
        assertEquals("一般三角形", triangle.calculateType(3, 4, 5));
    }

    @Test
    // 健壮性边界值方法：边界值测试
    public void testRobustBoundaryValues() {
        assertEquals("输入错误", triangle.calculateType(0, 3, 4)); // 边长小于1
        assertEquals("输入错误", triangle.calculateType(101, 3, 4)); // 边长大于100
        assertEquals("非三角形", triangle.calculateType(1, 2, 4)); // 不满足三角形条件
        assertEquals("非三角形", triangle.calculateType(1, 1, 3)); // 不满足三角形条件，但边长合法
    }

    @Test
    // 最坏情况一般边界值分析方法：极端情况下的三角形类型测试（假设边长均在1-100内）
    public void testWorstCaseGeneralBoundaryValues() {
        assertEquals("等边三角形", triangle.calculateType(1, 1, 1)); // 最小等边三角形
        assertEquals("等腰三角形", triangle.calculateType(1, 100, 100)); // 最大不等边三角形
    }

    @Test
    // 最坏情况健壮性边界值分析方法：结合边界值和三角形性质进行测试
    public void testWorstCaseRobustBoundaryValues() {
        assertEquals("等腰三角形", triangle.calculateType(50, 50, 99)); // 两边之和接近等于第三边的最大情况
        assertEquals("非三角形", triangle.calculateType(1, 1, 2)); // 最接近构成三角形但实际不能构成的情况
    }
}