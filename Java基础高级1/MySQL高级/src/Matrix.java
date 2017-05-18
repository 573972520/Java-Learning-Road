
public class Matrix
{
	//计算最优值
	public void matrixChain(int[] p, int[][] m, int[][] s)
	{
		int n = p.length - 1;
		for (int i = 1; i <= n; i++)
		{
			m[i][i] = 0;
		}
		for (int r = 2; r <= n; r++)
		{
			for (int i = 1; i <= n - r + 1; i++)
			{
				int j = i + r - 1;
				m[i][j] = 999999999;
				s[i][j] = i;
				for (int k = i; k < j; k++)
				{
					int t = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
					if (t < m[i][j])
					{
						m[i][j] = t;
						s[i][j] = k;
					}
				}
			}
		}
	}

	//构造最优解
	public void TraceBack(int[][] s, int i, int j)
	{
		if (i != j)
		{
			TraceBack(s, i, s[i][j]);
			TraceBack(s, s[i][j] + 1, j);
			System.out.println("Multiply A[" + i + ":" + s[i][j] + "] and A[" + (s[i][j] + 1) + ":" + j + "]");
		}
	}

	//打印出加上括号的最优解方案
	public void OptimalParens(int[][] s, int i, int j)
	{
		if (i == j)
		{
			System.out.print("(A" + i);
		} else
		{
			OptimalParens(s, i, s[i][j]);
			OptimalParens(s, s[i][j] + 1, j);
			System.out.print(")");
		}
	}

	//测试
	public static void main(String[] args)
	{
		int[] p = { 30, 35, 15, 5, 10, 80, 25, 65, 40, 20 };
		int n = p.length;
		int[][] m = new int[n][n];
		int[][] s = new int[n][n];
		Matrix m1 = new Matrix();
		m1.matrixChain(p, m, s);
		System.out.println("该矩阵阶乘子问题数乘的次数");
		for (int i = 1; i < m.length; i++)
		{
			for (int j = 1; j < m.length; j++)
			{
				if (i > j)
				{
					System.out.print("----" + "\t");
				} else
				{
					System.out.print(m[i][j] + "\t");
				}
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("该矩阵阶乘子问题数乘的次数");
		for (int i = 1; i < s.length; i++)
		{
			for (int j = 1; j < s.length; j++)
			{
				if (i > j)
				{
					System.out.print("----" + "\t");
				} else
				{
					System.out.print(s[i][j] + "\t");
				}
			}
			System.out.println();
		}

		System.out.println();
		System.out.println("该矩阵阶乘的最优解");
		m1.TraceBack(s, 1, n - 1);
		m1.OptimalParens(s, 1, n - 1);
	}
}
