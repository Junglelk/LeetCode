package normal.easy.quesiton_0175.CombineTwoTables;

/**
 * <pre>
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * personId是该表的主键列。
 * 该表包含一些人的ID和他们的姓和名的信息。
 * </pre>
 * <pre>
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * addressId是该表的主键列。
 * 该表的每一行都包含一个ID = PersonId的人的城市和州的信息。
 * </pre>
 * 编写一个SQL查询来报告 Person 表中每个人的姓、名、城市和状态。如果 personId 的地址不在 Address 表中，则报告为空  null 。
 * <p>
 * 以 任意顺序 返回结果表。
 * <p>
 * 查询结果格式如下所示。
 * <pre>
 * 输入:
 * Person表:
 * +----------+----------+-----------+
 * | personId | lastName | firstName |
 * +----------+----------+-----------+
 * | 1        | Wang     | Allen     |
 * | 2        | Alice    | Bob       |
 * +----------+----------+-----------+
 * Address表:
 * +-----------+----------+---------------+------------+
 * | addressId | personId | city          | state      |
 * +-----------+----------+---------------+------------+
 * | 1         | 2        | New York City | New York   |
 * | 2         | 3        | Leetcode      | California |
 * +-----------+----------+---------------+------------+
 * 输出:
 * +-----------+----------+---------------+----------+
 * | firstName | lastName | city          | state    |
 * +-----------+----------+---------------+----------+
 * | Allen     | Wang     | Null          | Null     |
 * | Bob       | Alice    | New York City | New York |
 * +-----------+----------+---------------+----------+
 * 解释:
 * 地址表中没有 personId = 1 的地址，所以它们的城市和州返回null。
 * addressId = 1 包含了 personId = 2 的地址信息。
 * </pre>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combine-two-tables
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Jungle
 * @since 2022/4/5 18:43
 */
public class Solution {
}
