# leetcode
2019/3/25
记录一下自己的刷题学习生活 向着FLAG进军

headfirstjava:
自己看到了386页
今天学习的是exception 比如何时用exception 用exception时候的一些规则 
并且后面一章讲的是GUI了 明天打算开始看UCB 的61B 不过网上找不到06版的了，只能看一下14spring版的
同时要记得每看完一个视频把project和homework做好.

leetcode：
今天主要是刷了dp的题目

276 paintfence
这道题可以算作是dp的题目，因为对于每一个n的paint数目，总是和n-1相关.
我们从0开始举例，帮助我们梳理思路. 
当n=0时 很明显 结果为0（毕竟没有fence我们怎么上色呢哈哈哈）
当n=1时，此时也很明显，结果为k 
当n=2时，此时我们要分类讨论了，此时有两种情况
1.第二块涂得和第一块不同 diff
假设第一块涂了任意的颜色，那么有k种选择，那么第二块的选择就是k-1种，所以这种情况总共的数目就是diff=k*(k-1)
2.第二块涂得和第一块相同 same
同样第一块涂任意颜色有k中选择，第二块只有1种，因此这种情况总共的数目是same=k*1种
那么当n=2时，返回的结果就是 diff+same =k*(k-1)+k;

现在思路开始有点熟悉了，我们再来看n=3的时候
我们由上面知道了n=2的时候，只有两种情况，那么我们的思路应该是，在涂了2块fence的基础上，接下来我们只需要再涂一个fence，然后讨论出应有的情况即可。此时思路和上面n=2讨论的差不多，也是两种情况。
1.第三块涂得和第二块不同 diff
我们此时会发现,实际上有的情况是第二块中的 diff=(same+diff)*(k-1)
2.第三块涂得和第二块相同 same 
此时实际上我们会发现情况是第二块中所有的情况 就是之前diff（因为不能再选择之前第二块same的情况）

因此对于循环体内的代码思路 我们应该是 
	int prediff=diff;
	diff=(same+diff)*(k-1)
	same=prediff;

最后返回 same+diff;


256 painthouse

同理这道题目也是dp的问题 因为对于每个当前状态的取值 我们都需要用到前面一个状态来判断
我们让i这个指针从1到n-1
(要注意，我们接下来的代码会改变这个cost数组)
那么我们可以知道 cost[i][0]=cost[i][0]+Math.min(cost[i-1][1],cost[i-1][2]);
			cost[i][1]=cost[i][1]+Math.min(cost[i-1][0],cost[i-1][2]);
			cost[i][2]=cost[i][2]+Math.min(cost[i-1][0],cost[i-1][1]);

			因为我们不知道哪个最小，所以实际上我们应该要返回三个中的最小值

62 unique paths

这个题目也比较简单，由于机器人只能往下或者右边走，因此我们如果用dp[i][j]表示机器人走到当前第i行，第j列所有的情况，那么就有dp[i][j]=dp[i-1][j]+dp[i][j-1];
因此我们只需要利用关系式，遍历每一个i，j。最后返回dp[m][n];
注意这道题有点trick的地方在于边界，我们new出的数组是 int dp=new int [m+1][n+1]
然后给定dp[1][1]=1，我们要注意这道题目我们的i和j从1遍历到m,n，并且当i=1&&j=1的时候，
要让循环continue，否则dp[1][1]=dp[1][0]+dp[0][1]=0+0=0，造成之后的结果也会错误。
其实这道题我们可以对空间进行优化，其实不需要二维数组，一个一维数组就够用了。做完二维数组到一维数组的优化后，我们再仔细想一下，实际上可以用两个变量存储我们需要的值。这样空间复杂度由O(n^2)->O(n)->O(1);
后记：我自以为是的以为可以将空间复杂度降为O(1),实际这里还有一个out loop. 所以实际上是不行的. 两个变量每次都要被更新m-1次，所以做不到用两个变量就实现。


63 unique paths II 

这个题目直接给我们一个二维数组了，我们这道题目的思路还是一样，利用dp[i][j]=dp[i-1][j]+dp[i][j-1].
同上，实际上我们可以进行一个优化，不需要用到二维数组，我们只需要 int []dp=new int[width] 并且初始化dp[0]=1;
其中这个width是数组的列数 即 obstaclegrid[0].length; 然后我们利用如下循环体遍历元素

for(int []grid:obstaclegrid){
	for(int j=1;j<width;j++){
		if(gird[j]==1){
		dp[j]==0;
		}else{
		dp[j]+=dp[j-1];
		}
	}
}
最后return dp[width-1]就可以。 从二维降到一维，一开始也许会比较难理解，但是画一个图，我们会发现在二维数组的遍历中，实际上元素都是按行，从左往右被遍历，如果按照dp的递推式，第一行上面一行所有的dp元素都为0，所以我们可以降到一维。

64 Minimum Path Sum

这道题要注意，在loop内进行dp递推的时候要分为三个情况讨论。


3.26
96 Unique Binary Search Tree

这道题目可以从数学的角度来看，从最高vote的discuss上，我们得到了这么一种解法：

define g(n) 为长度为n时所有的BST数目 
		f(i,n)为当我们把i作为BST的根节点时所有的BST数目

从定义中我们可以发现几个规律 
1.g(n)=f(1,n)+f(2,n)+f(3,n)+...+f(n,n) 即把每个数都作为根节点，所拥有的情况相加就是总共的数目
2.f(i,n)=g(i-1,n)*g(n-i,n); 如果我们把i作为结点，那么 1至i-1的数目就在左子树，拥有的情况为g(i-1) i+1至n的数就在右子树,拥有的情况为g(n-i);

由上面两个公式，因此我们可以得出g(n)=g(0)*g(n-1)+g(1)*g(n-2);
通过两层循环，利用dp我们就可以求出g(n).
我们最后看一下底层的情况 显然g(0)=1 ，g(1)=1 即没有树的情况和只有一个数的情况均只有1种
之后我们用两层循环
for(int i=2;i<=n;i++){
	for(int j=1;j<=i;j++){
		g[i]=g[j-1]*g[i-j];
	}
}
最后return g[n];

95 Unique Binary Search Trees II
这道题目要求构建的一个BST的list	  比较容易想到我们用递归方法加上helper函数去构建
即 public List<TreeNode> helper(int min, int max);
        List<TreeNode> result=new ArrayList<>();
并且我们需要判断如果 min>max  直接return result
我们知道，每一个数字都能作为root 因此我们在helper函数内需要有一个循环 对于每一个数rt 
我们都要利用helper函数返回他的 leftList 和rightList 再根据leftList和rightList的情况讨论
如果 leftList.size()==0 那么我们有循环for (TreeNode right:rightList)直接new一个TreeNode 作为结点 并且传入当前rt的值，令root.right=right; 同理如果 rightList.size()==0;
else 我们有 for(TreeNode left:leftList){
				for(TreeNode right:rightList){
				 TreeNode root= new TreeNode(rt);
				 root.left=left;
				 root.right=right;
				 result.add(root)
				}
}

120 Triangle

	这道题目的思路是 我们可以从先倒数第二行看起，如果路径要通过第j个元素，那么下一行路径可以通过第j个或者第j+1个元素。我们直接对倒数第二行开始的j元素做一个modify.每个元素加上下一行的j和j+1元素中取小的一个元素。每行都是如此，最后，第一行的第一个元素就是我们要求的最小值
	这写代码的时候应该有两层循环，外层循环控制行数，内存循环控制第j个元素，每次内存循环，我们要拿出上一行元素。
	List<Integer>nextrow=triangle.get(i)

139 Word Break 

  这道题目我们如果用 记忆性递归会非常容易解得，其实动态规划类似于记忆性递归，都需要用到一定的空间去换取时间。

  我们主要利用一个helper()函数和一个set

 主要思路：helper("leetocde")= helper("")&&indict("leetcode")||helper("l")&&indict("eetcode")||helper("le")&&indict("etcode")||helper("lee")&&indict("tcode")||helper("leetcode")&&indict("code")||helper("leetc")&&indict("ode")||helper("leetco")&&indict("de")||helper("leetcod")&&indict("e") 

 152 Maximum Product Subarray

 这道题目的原理主要也是利用dp 因为数组中可能存在负数，并且出现负数乘负数导致最大的情况，因此我们初了 maxhere maxherepre maxsofar  还需要有minhere minpre 
每一轮中 maxhere=Math.max(Math.max(maxhere*nums[i],minhere*nums[i]),nums[i]);
这里一定要注意也要和nums[i]比大小，因为前两个数可能是一个正数一个负数，还没有nums[i]大（如果nums[i]>0)
 最后我们返回maxsofar


3.27 House Robber 
这个题目是典型的dp的题目，由于是一轮循环，实际上我们可以使用两个变量就解决问题..
我们定义两个变量 prenum 和 num 其中num是我们每次遍历到数组中数进行判断的数字，当然最后返回的也是num
prenum这个变量是记录num没有进行变化之前的变量.

在循环体内  我们的代码如下

for(int num:num)
	 int temp=num;
	 num=Math.max(num[i]+prenum,num);
	 prenum=temp;

	 一定要注意先把num给一个临时变量存储，再判断num的数值，最后再把num传给prenum.


3.28 

House Robber II
这道题目如果 如果思路正确，那么其实和house robber 一样，非常的简单
思路：我们只需要写两个rob函数，第一个函数我们让for循环从nums[0]遍历到nums[nums.length-2],最后返回num变量。而第二个函数我们让for循环从num[1]遍历到nums[nums.length-1]，然后返回num变量，最后在主函数内我们return 两个rob函数的最大值就好


221 Maximal Square 

这道dp题目 我们的思路是 用 dp[i][j]数组代表第i行第j列的可能有最大正方形边长。在两层for循环内，如果我们发现matrix数组的值=="1"。那么我们就可以有这样的方程式 
dp[i][j]=Math.min(Math.min(dp[i][j-1],dp[i-1][j]),dp[i-1][j-1])+1; 我们要知道，如果一个点的左上角、上面、左边为0的话，是不可能构成一个正方形的，因此我们要求最小值，后面要记得+1 代表matrix的值。 最后一定要记得res要乘res，即返回的是res的平方（因为我们要求的是面积）

264 
ugly number 的顺序是1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
因为每个数字都能被2，3，5除，我们可以这么看这个问题 ugly number都在以下三个序列中

 (1)1*2, 2*2, 3*2, 4*2 ...
 (2)1*3, 2*3, 3*3, 4*3.... 
 (3)1*5, 2*5, 3*5, 4*5....
即所有的ugly number都在 （1至n）*倍数（2，3，5）中。
注意我们写代码的边界条件n=0 return 0 ; n=1显然应该return 1
 我们可以定义一个数组res  设置res[0]=1，再定义三个变量n2,n3,n5; 
 对于每个res[i]，这里的动态转移方程是取res[n2]*2 res[n3]*3,res[n5]*5中的最小值
 并且如果res[i]=res[n2]*2 n2++ 同理对如果res[i]=res[n3]*3 n3++;
 最后返回res[n-1]就是我们想要的值。

279 Perfect Squares
这道题目我个人感觉有点难，主要是dp的这个思路没那么好想.
看了leetcode上的discuss，勉强写一下这个高vote的思路..
dp[n]表示 给定n的perfect square的数目 ...我的天这个不是废话吗，关键是怎么构建出状态方程。
这个思路的核心是：dp[n] = Min{ dp[n - i*i] + 1 },  n - i*i >=0 && i >= 1

举几个例子：dp[0] = 0 
dp[1] = dp[0]+1 = 1
dp[2] = dp[1]+1 = 2
dp[3] = dp[2]+1 = 3
dp[4] = Min{ dp[4-1*1]+1, dp[4-2*2]+1 } 
      = Min{ dp[3]+1, dp[0]+1 } 
      = 1				
dp[5] = Min{ dp[5-1*1]+1, dp[5-2*2]+1 } 
      = Min{ dp[4]+1, dp[1]+1 } 
      = 2
						.
						.
						.
dp[13] = Min{ dp[13-1*1]+1, dp[13-2*2]+1, dp[13-3*3]+1 } 
       = Min{ dp[12]+1, dp[9]+1, dp[4]+1 } 
       = 2

      看了例子后，我的理解就是 这个状态方程是通过遍历出所有dp[n-i*i]+1的值，由于我们要找出最少平方数组成n，因此我们要从取出dp[n-i*i]+1当中的最小值。
      比如dp[100]实际上dp[100]=dp[100-10*10]+1 =1,因为我们减去了一个平方数，因此结果+1;


300 Longest Increasing Subsequence
这道题真是看起来比较简单，实际上不好好想真的十分容易出错.
从brute force看这道题目 如果找到每一个subsequence 判断是否是递增 这样的时间复杂度已经是o(2^n)肯定不行.
因此我们利用dp的思想，我们定义dp[i]为以第i个元素结尾的最大递增子序列长度
并且在开始循环计算结果时，我们先Arrays.fill(dp,1)，将每个第i个元素结尾序列长度设为1
那么我们还需要一个j在i之前 检查nums[i]是否大于nums[j]。如果大于，我们才能进行dp状态方程的改变。
for(int i=1;i<nums.length;i++){
	for (int j=0;j<i;j++){

	}
}
	那么如果nums[i]>nums[j] 我们会有dp[i]=Math.max(dp[j]+1,dp[i]);
这道题可以多看看花花的讲解，我觉得讲的还是非常棒的.


309  Best Time to Buy and Sell Stock with Cooldown
这道题和一般的dp题目有点区别，解题的关键是在于画出三个状态  
我称之为 canbuy  cansell onlyrest 

canbuy的意思是可以买也可以选择不买 cansell的意思是可以卖可以选择hold住stock 
onlyrest是只能休息（状态从cansell来）根据这样画出状态图  题目就变得非常容易
我们就有：
     		canbuy[i]=Math.max(canbuy[i-1],onlyrest[i-1]);
            cansell[i]=Math.max(cansell[i-1],canbuy[i-1]-prices[i]);
            onlyrest[i]=cansell[i-1]+prices[i];

要注意 初始化的时候， canbuy[0]=0, cansell[0]=-price[0] 因为第一次卖肯定是买了第一只股票的
onlyrest[0]=Integer.Min_VALUE;

并且这道题目我们可以用几个变量存储需要的值，把空间复杂度降为O(1)，但我个人感觉那样一开始不太利于理解这道题目。

也要注意变量的名字设置，不然容易误导，下面是优化空间后的代码.

int sold=0;
        int rest=0;
        int hold=Integer.MIN_VALUE;
        for(int price:prices){
            int prev_sold=sold;
            sold=hold+price;
            hold=Math.max(hold,rest-price);
            rest=Math.max(rest,prev_sold);
        }
        return Math.max(sold,rest);

我们要注意，sold（卖掉）对应上面onlyrest[i] hold对应cansell[i] rest对应canbuy[i]

3.29

322 Coin Change
这道题目我们用dp[i]代表给定i数目的钱，最少数目的coins组合，因此最后我们返回的是dp[amount];
注意我们初始化dp的时候 dp数组长度为amount+1 并且让每个索引对应的数为 amount+1，再设置dp[0]=0，因为没有钱的时候coin change种类应该为0，这样就完成了初始化。
接着我们会在代码中算出dp[1],dp[2],dp[3] 利用递推关系求出dp[amount];
我们的dp递推关系应该是 dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
我们内循环j的时候，会考虑到每一个coin的值，利用dp[i-coins[j]+1]求出dp[i]的最小值。
为什么是dp[i]=Math.min(dp[i],dp[i-coins[j]+1])呢？我们拿一个例子来举例，如果我们要求dp[3]，代表组成3块钱最小的coins数目，那么我们会遍历所有的coins[j]，对于dp[3] 有两个情况
dp[3-1]+1=dp[2]+1  代表dp[2]加上用了一个一块钱总共的数目 dp[3-2]+1=dp[1]+1 代表dp[1]+用了一个两块钱的总共的数目。


338 Counting Bits
这道题目要求的是每个数组中二进制表示中1的数目，返回一个数组。
这道题目有个非常简单的解决方法
res[i]=res[i&(i-1)]+1 举个例子 14的二进制表达是1110  与13的二进制表达是1101 1110&(1101)=1100 实际上是移除了最右边最小的1，因此14的二进制表达1数目是12的二进制表达的数目上加1。 因为我们之前已经计算了一系列的数从n=0,1,2,3,4开始，所以我们也有会12的二进制表达数目，因此我们通过表达式可以得到14的
二进制数目。


647 Palindromic Substrings
这道题目比较简单，思路是 从每个索引开始都去寻找可能形成回文的情况，并且我们要对奇数和偶数的情况都要考虑


746 Min Cost Climbing Stairs
思路：bottom-up dynamic programming
dp[i]表示爬上i层所用的最低cost 注意为了便于理解 我们 [] dp= new int [cost.length+1];

base case: dp[0]=0
			dp[1]=cost[0];
dp formula: 
		dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);

		return Math.min(dp[cost.length],dp[cost.length-1]）;

3.30
84  Largest Rectangle in Histogram
这道题目首先我们从最基础的brute force出发。思路是我们利用一个索引cur,从左往右如果是heights[cur]<=heights[cur+1]; 那么我们直接跳过这次循环，原因很好理解，如果后面的直方图长度大，那么最大的矩形面积肯定能用到后面的直方图。 如果cur==height.length-1||heights[cur]>heights[cur]我们进入计算的过程
注意要先判断cur==height.length-1 不然会造成数组越界。同时定义minheight=heights[cur];
对于每一个cur 我们都要再次做一个for循环 索引i从cur 递减到0，计算出最小高度min(height[i],minheight) 再计算最大的面积。
上面的brute force方法时间复杂度是O(n^2) 我们可以利用stack数据结构对时间复杂度进行优化。此时的解题思路是，对于每一个直方图，找到这个直方图左边比他小的最大直方图的索引以及 这个直方图右边比他大的最小直方图的索引。

85 Maximal Rectangle
这道题目我们可以用到84题的解法，把一行作为底，往上看成一个直方图。如果该行某个数字为0，那么height就直接为0，否则heights[j]++;然后把heights数组传入84题写好的function中，返回一个最大面积。


7 Reverse Integer
这道题目主要要注意的地方是，要判断x reverse后有无可能造成 overflow, 并且lc的discuss里有人测试，输出Integer.MAX_VALUE+1 结果是Integer.MIN_VALUE
因此我们在对x取模求得tail并且在赋值newresult=10*result+tail 后要进行一个判断
判断方法是 如果 (newresult-tail)/10!=result  返回0

171 Excel Sheet Column Number
这个题没有太大的难度，就是利用字母对应数字，我们可以知道，这样的数字字母组合相当于是数字的二十六进制，
写一个

172.  Factorial Trailing Zeroes
这道题我们如果是人脑去思考，要看有几个零，可能想到的是先将n阶乘后，将得到的数不断的除以10，每除一次累加一次，然后只要这个数有小数点，我们就停止除，看看累加了几次。然而这样写其实存在问题，因为我们要对n进行阶乘，实际上当n只要到13 ，便会超出int的范围，当test case 为30 ，超出了long的范围，因此这种解法实际上不可以，我们其实可以换个角度想， 给定一个n，我们知道这个数是
n*(n-1)*(n-2)*(n-3)，我们知道10=2*5 而给定一个n阶乘后 2的数目总会大于5，因此我们找到5的数目即可。
n阶乘后末尾0的个数就是n在不等于0时不断除以5的次数。

4.1
191 Number of 1 Bits
这道题目要求我们算一个二进制表达中1的数目，我们的思路就是 让n每次和1进行且操作，count+=返回的数值；
但是要注意一些，对于n我们要使用逻辑右移 即>>>,而不是算术右移>>。算术右移的问题在这里的问题是，如果我们输入 Integer.MAX_VALUE+1的数，那么会这个输入的数会变成
Integer.MIN_VALUE。 用二进制表达式 1000 0000 0000 0000 0000 0000 0000 0000 实际上只有一个1.
而对负数使用算术右移，前面会补1，这样会造成结果错误。 因此我们要使用逻辑右移>>>

190 Reverse Bits
这道题目解法非常直接，初始化一个变量result 
每次result+=n&1 然后将n逻辑右移  当循环次数小于31次时，将result算术左移 (等于一共将result进行了31次算术左移)


317 Sum of Two Integers
这道题目要求我们不用+符号计算两个数的和  思路肯定是利用Bit 操作
我们将两个数都用二进制表示，会发现两个数异或后，不断异或上 两个数的&操作，有一个数会不断变大，一个数不断变小，直到一个数变为sum，另一个数变为0
code思路是    int c=0;
	while(b!=0){
			 c=a&b
			 a=a^b;
			 b=c<<1;
			 }
			 return a


230 Kth Smallest Element in a BST
这道题目discuss上面有binary search的解法 有dfs的解法 我更偏向于dfs的解法，思路就是前序遍历，设置一个TreeNode p=root; 当p!=null时，不断的push进入stack，然后pop出一个TreeNode，count++,再判断 count是否等于k 如果等于就返回这个 TreeNode 的val。 
最后都没有找到的话我们就认为不存在，可以返回一个Integer.MIN_VALUE


4.2 这几天把binary search的tag好好的过一遍

35 Search Insert Position
这道题目就是典型可以用binary search解的题目 我们可以用leetcode上面所说的模板1
这三个模板我第一次接触binary search的时候还是有点迷糊 lc上这么解释模板1
(left<=right)这个模板是最基础的二分查找，查找条件无需比较边界？ 而且不需要后序的查找，因为我们在while循环的每一步已经查找了结果。
最后要注意因为while loop循环结束的时候，我们的lo总是比hi 要大1，所以最后要根据题目决定返回lo 还是hi  这道题目我们分析后得出应该返回lo

69. Sqrt(x)
这道题目我们也可以用模板1解决 
需要注意的是 初始化lo的时候我们赋值不能是0 而是1 因为当input 为0的时候，会进入while loop循环
导致除数是0，这样会造成runtimeerror。 最后由于我们要把数末尾的小数点去掉，由于条件结束时 lo=hi+1 因此我们要返回hi。

167 Two Sum II - Input array is sorted
这道题目虽然tag是 binary search, 但其实解法更像用 two pointer,我们定义两个 pointer lo 和hi
lo=0 hi=numbers.length-1。注意这道题的while loop 条件我们只需要
lo<hi就可以，因为题目中说一定会有解，并且index1<index2

278 First Bad Version
lc上面说模板2我们在搜索的时候要判断检查右边的元素？
Use element's right neighbor to determine if condition is met and decide whether to go left or right 并且由于最后lo==hi，我们需要做一个post-processing。
这道题用lc上面的模板2会更加容易解题，原因是我们每次用isbadversion(mid)判断一个函数如果为false;说明这个版本没坏，坏的第一个版本肯定不是这个mid，至少在右边一位，因此满足(!isbadversion(mid))的时候，我们让left=mid+1 然鹅当情况不满足上面进入else逻辑时，即我们发现这是一个badversion 我们只能让 right=mid 原因是我们不知道这个mid 是不是第一个坏的version，可能左边还有一个坏的version
最后由于题目中说肯定会有坏的version 因此当跳出循环 lo==hi时，我们也不用做多余的post-processing 因此我们返回lo就满足要求

367 Valid Perfect Square
这道题目首先有一个不是binary search的解法 有一个数学规律是平方数可以被1+3+5+7+....+(2n)-1表示。那么依据这个数学规律我们很好判断这个数是不是平方数。
如果使用binary search解法，我们利用模板1解决

要注意两个点  1判断的时候要用mid*mid==num 如果用num/mid=mid 那么由于int的类型，有些输入比如5/2的小数点被抹去，也会返回true
		 	2.mid这个变量要设置为long类型 因为有个test case是2147483647
				算到mid 然后mid*mid就会造成StackOverflow

374  Guess Number Higher or Lower
这道题用binary search模板1 没什么好讲的

475 Heaters
这道题目用二分法可以解决问题。要注意的是这个题目没有说heater一定会在房子处，所以有可能有边界的case 例如 houses=[1 2 3 4] heaters=[1,5] 这样的情况

我们的思路是 1.对于每一个house，找到他两边的heater，因此我们需要对heaters进行排序，这个题没有说heater是排序的，所以我们自己要做排序工作。
			2.我们计算这个house 它旁边left heater 和 right heater的距离，两个当中取小，那么这个屋子肯定能被heater warm到 这里我们也要注意
			有可能 这个house是在一边的，要注意边界情况的判断处理。
			3.我们算完2中的每个房子的最小值后，要返回最小值中的最大值。
		最后要注意这个题目中 Array类 binarySearch()方法的使用,要注意这个方法的返回值 
		以及 ~操作符的妙用。

704 Binary Search
用binary search模板1 没什么好讲的

852 Peak Index in a Mountain Array 
我用了binary search的模板1  但是看lc上的模板，好像要用3更合适？？我其实现在有点迷糊。


33 Search in Rotated Sorted Array

这道题目我觉得还是有点难度的  
	我们的思路是这样的 将数组任意地方劈开，总有一半是有序的，基于这个性质 
	我们可以先找到哪一段是有序的，方式是判断端点与nums[mid]的大小。然后target在某一段的话 再进行二分搜索， 把另一段丢掉。 
注意点：边界条件 一些等号很容易忘，很容易弄不清，我到现在（4.4)还是有点迷糊。


4.3
忙着做物理院的期中毕设检查，没刷题，today是焦虑小王子 完全不像做毕设 sigh

4.4 
34 Find First and Last Position of Element in Sorted Array
这道题目一定要注意他没说一个元素只出现2次，可能出现了很多很多次
首先，对这道题目来说，因为target在一个数组中出现至少两次，因此我们是不能使用lc的模板1的，因为模板1是找到一个数就可以返回。但是这个题目不行，就算我们有一个mid nums[mid]==target 我们也不能确定这个mid对应的值的左边或者右边还有没有需要找到元素。因此需要用到模板2。
这个题目的思路是：先找到target对应的左边界 再找对应的右边界。
找左边界的思路：当我们发现 nums[mid]<target 
			说明这个时候数组中要查找的元素肯定在mid右边的位置 
			那么我们令 lo=mid+1; 
			else 不论是 nums[mid]=target 或者 nums[mid]>target 说明数组中要查找的元素在左边或者是这个位置 由于我们是要查找数组的左边界，此时我们就让
			hi=mid;
	最后退出循环的时候 我们会有一个post-processing 
	检查 nums[lo]==target 如果相等 res[0]=lo;不相等 res[0]=-1;
找右边界的思路是同样的  此时我们要重新设置 hi=nums.length-1,并且无需再对lo设置。
这里我们要注意的是 虽然是利用模板2 但是我们一开始初始化的时候hi不是不是不是nums.length ！！！
否则输入样例为 [2,2] 3 的时候就会造成indexoutofbound。
重新设置 hi=nums.length-1 后 我们设置mid的时候也要mid=lo+(hi-lo)/2 +1;这里+1就是为了让每次二分时元素偏向右边。后面也是和找左边界相同的思路。
		如果num[mid]>target 我们知道数组元素肯定在mid索引的左边 那么我们要令 hi=mid-1 
		其余情况 我们就是让 lo=mid;

总结：这道题目除了思路 我们也要非常注意变量的初始化条件

74 Search a 2D Matrix 
思路：由于matrix内的元素是每行sorted 每列也是sorted ，并且The first integer of each row is greater than the last integer of the previous row. 那么我们可以把整个matrix看成是一个sorted list, 直接利用二分法进行search
要注意的是：初始化hi的时候 由于我们需要col*row，可能会造成overflow 这也是一个弊端。

由于这道题目我们只需要找到target就可以return true，因此可以用lc的模板。在判断的时候要注意 
每当有一个mid的时候 我们需要在matrix判断的元素是  matrix[mid/col][mid%col];


81. Search in Rotated Sorted Array II  
这道题是33题的 follow up,我个人感觉这两道题目还是非常容易错的。
这道题目具体的可以看看王子蓝老哥的视频，非常有用。
我感觉我在边界条件的处理上总是弄不清，有点upset。

153. Find Minimum in Rotated Sorted Array
思路：首先我们可以判断 if(nums[lo]<nums[hi]) 
					如果是的话，说明数组没有rotate，我们直接返回nums[lo]
	 else 说明数组rotate了  
	 		我们可以利用nums[lo]和nums[mid]来帮助判断
	 	想一下端点图，作一个图。我们会发现if(nums[mid]<nums[hi]) 说明断点在左边或者mid处
	 			我们让hi=mid;
	 			else 说明断点在右边 我们让lo=mid+1；

	 		我们令循环while(lo<hi) 最后退出循环时lo=hi 就是最小值的索引

网上看到了一个比较清晰的思路 且有几个注意点：
下面一段我写的，更为简洁的代码。看几个例子，7 8 0 1 2 3 4 5 6，mid=2；3 4 5 6 7 8 0 1 2，mid=7。
mid > end的时候，代表前面是排序的，可能折断点在后面，于是start=mid+1。
mid < end的时候，代表后面是排序的，可能折断点在前面，但是这时候不能end = mid - 1。为什么？看一个例子，4 5 0 1 2。这时mid < end，但是mid就是折断点，所以这时end = mid。
mid == end的时候，说明当前mid就是最小值。
为什么mid要和end比较，不能和start？因为除非在start==end的情况，否则mid不可能等于end，但是start可能等于mid，比如只有两个元素，[2,1]，这时start==mid<end，所以返回的是错误的2。
另外还要注意一点。while内部更新start和end的各个条件要符合互相没有交集，但是合起来又可以组成全集的原理。因为前半句违背了，可能一次更新多次start和end，这样有些范围就跳过不搜索了。后半句违背了，可能使得start和end得不到更新，引起死循环。


4.5 

154 Find Minimum in Rotated Sorted Array II
这道题目是153题的 follow up 只是input的nums中可能出现重复的情况 其实和81题基本一样
当我们在进行nums[mid]与nums[hi]判断的时候，可能出现nums[mid]===nums[hi] 的情况，这时候我们无法判断断点位置，也就不能判断应该取舍哪一段，此时我们可以让hi--。之后再循环判断。这样的题目最差的时间复杂度可能会到O(n),因为如果一个数组中全是duplicate，那么只会进行hi--操作。

162 Find Peak Element

这道题目如果用one pass,时间复杂度是O(n)。在input上百万时所用的时间会比较长，performance不行。
同样，这道题目我们可以利用二分法，每次判断 
			if(nums[mid]>nums[mid+1])  hi=mid;
			else lo=mid+1;

240 Search a 2D Matrix II 
由于题目中给出的说明：
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
 以及样例 
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
因此我们不能把数组当做一个sorted list来处理，就无法像之前那个题目直接对数组整体二分查找。 
第一个思路是我们对每行元素都进行一次二分查找，这样时间复杂度是O(nlogn)
第二个思路是 我们把第一个查看的元素定在右上角，
当target<nums[row][col](此时row=0 col=matrix[0].length-1) 我们令col-- 否则 row++
这样时间复杂度是O(m+n);

230 Kth Smallest Element in a BST
这道题目也被归在了binary search tag下？？有点不明白。
这道题目直接dfs in-order， 利用一个stack 每次结点不为null的时候就push进去，为null就pop出一个 给一个++count变量,判断是否是k，不是的话就令p=p.right;

270 Closest Binary Search Tree Value 
我们利用BST的性质，可以进行二分搜索。初始化一个变量int closest=root.val
当p!=null的时候 如果closest-target的绝对值<root.val-target的值，那么closest保持不变，否则cloest=root.val。
再进行判断接下来遍历的方向是  如果target<root.val 那么我们继续搜索左子树，否则搜索右子树

287 Find the Duplicate Number
这道题目如果用额外的数据结构 hashset 非常容易解题
但是如果要求我们不用额外的空间解题，我们可以考虑使用Floyd's Tortoise and Hare(cycle detection)
想法是用fast变量与slow变量，每次fast=nums[nums[fast]] slow=nums[slow];类似链表的环，最终总有fast=slow。找到fast=slow后，我们再让fast=0，此时每次fast=nums[fast]，slow=nums[slow]，当fast=slow时退出循环，此时fast=slow=我们要求的结果。

 300 Longest Increasing Subsequence
 这道题目之前一直想的是利用dp解题 两个for循环遍历所有的子序列 
 每次在内循环比较 dp[i]=Math.max(dp[i],dp[j]+1) 出了内循环 我们再存储一下不同i之间的最大值
 result=Math.max(result,dp[i]);
 利用dp 时间复杂度为O(n^2) 

 这道题目其实有一个更好的方法，利用二分法 
 我们创建一个tails数组 tails[i]表示当 LIS长度为i+1时最小的尾巴元素
 举个例子，如果我们有nums=[4,5,6,3] ，那么所有的子序列为：

len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
len = 3   :      [4, 5, 6]            => tails[2] = 6

我们可以比较容易的证明 tails是一个递增的数组，因此我们就可以在tails数组中利用二分查找更新元素的位置
每次我们只需要做两件事情
(1)如果取出的x元素大于所有的tails中的元素，只要把x加进行，并且增加size
(2)如果 tail[i-1]<x<=tail[i]，更新tail[i]，令其等于x


			
4.6 

392. Is Subsequence
这道题目原题不用binary search做，可以直接利用two pointers 
indexS与indexT  循环成立的条件是  indexT<t.length();
		if (s.charAt(indexS)==t.chatAt(indexT)){
				indexS++;
				并且如果indexS==s.length() 说明我们已经在t中找到一个subsequece
				}

follow up: 题目中说可能会有多个要查找的s 例如1百万个，这时候我们上面思路的算法运行时间是O(n)所用的时间就会比较的长，因此我们需要提高算法的performance 
这时候我们利用利用空间换取时间，先做一个关于字母T的表。
我们创建一个存放List对象的数组。然后遍历一遍t 将p里面的字母的下标都存到相应的list中，如下
// Eg-1. s="abc", t="bahbgdca"
    // idx=[a={1,7}, b={0,3}, c={6}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=3
    //  i=2 ('c'): prev=6 (return true)
    // Eg-2. s="abc", t="bahgdcb"
    // idx=[a={1}, b={0,6}, c={5}]
    //  i=0 ('a'): prev=1
    //  i=1 ('b'): prev=6
    //  i=2 ('c'): prev=? (return false)
然后利用一个prev变量表示本轮搜索字母的位置 
首先如果 idx[s.charAt[i]==null]说明字母表中没有i位对应的字符，直接返回false
通过binarry search方法 找到prev在idx[s.charAt(i)]中的位置.
如果我们发现了binaarySearch的返回值j==idx[s.charAt(i).size()]说明搜索的prev位置在最后一位，
说明这时候字母大(例如c>b)的list中所有的索引小于前一个字母，那么这样不满足一题，直接返回false

对String s全部搜索完之后，返回true 




4.7
658 Find K Closest Elements  
思路：由于我们要找一个连续的k位数组，所以我们可以采用二分法  初始化的时候 
lo=0 hi=arr.length-1-k  记住我们要寻找的是以lo至hi中间的一个索引 由这个索引开始连续传入k个数
然后我们比较  diff(x,arr[mid]) 与 diff(x,arr[mid+k]) 

if(diff(x,arr[mid])>diff(x,arr[mid+k])) 说明右边更好（值左边的差值更大）
我们舍弃掉左半边 lo=mid+1;
反之 hi=mid-1;

当跳出循环时以 lo至lo+k为的索引的数组元素就是我们要返回的一个list

100. Same Tree 
本周要把DFS和BFS的题复习一遍，多刷几个题，顺便好好理解一下BFS和DFS
思路：一般这种tree的题目都要定义一个helper函数，本题传入的参数是两个节点，
base case: p==null&&q==null return true;
		   p=null||q==null return false;
		 对于传入的两个树的根节点 我们要判断p.val==q.val 
		 如果相等返回 同样helper(q.left,p.left)&&helper(q.right,p.right)
		 不相等 返回false 

101. Symmetric Tree
base case 和 same tree的写法一样 唯一要注意的就是题目要求的是对称 因此当辅助函数里面的
left.val==right.val时            
return isSymmetricHelp(left.left,right.right)&&isSymmetricHelp(right.left,left.right);

104. Maximum Depth of Binary Tree
base case: 如果root==null 那么这一层depth=0
		  否则返回 1+Math.max(maxDepth(root.left),maxDepth(root.right));
		  题目看代码就可以很好的理解，感觉不需要怎么讲

108. Convert Sorted Array to Binary Search Tree
这道题目可以用二分法做，因为我们知道BST的性质就是左子树val小于根节点 右子树val大于根节点
并且给定的array已经排过了序，因此我们可以用二分法构建一个结点的左右子树。
写一个helper函数，传入的参数是结点，以及数组中的lo hi值 每一个helper函数都利用二分法，找到mid值
利用nums[mid]作为根节点的val，再构建该结点的左右结点。
第二次：还是比较简单的这个题目

110. Balanced Binary Tree
这道题目可以看看王子蓝老哥的讲解视频，讲的非常清楚 
一个平衡高度的树满足任意结点的任意两个子树高度差不超过1，这个定义是非常重要的，这就要求
如果一个整体树是平衡高度的二叉树，那么他的左右子树也是平衡高度的二叉树。
因此对于给定一个结点，我们需要知道一个boolean代表子树是否是平衡高度树，以及一个int代表树的高度，但是我们的一个方法只能返回一个类型的值，那么怎么办呢。这时候我们可以考虑，如果一个数不是平衡高度数，我们可以返回 -1！！！有了这个思想后，后面的代码也就相对比较简单了！

111. Minimum Depth of Binary Tree
这道题目和104题很像，但是容易错的地方在与如果一个结点只有一个子树，那么要另外加一个判断

112. Path Sum
这道题目也非常的简单 利用递归。 base case 1.node为null,直接返回false
									2.node.left==null&&node.right==null&sum==root.val 直接返回true
否则我们再查看该结点的左右子树


257. Binary Tree Paths
同样利用一个helper函数 递归(DFS） 

339. Nested List Weight Sum
一道lc锁题目 采用DFS. Base case是list中的当前item, 是integer, 乘以depth加到sum中return. 若不是integer, 就对其depth+1做dfs.


559.Maximum Depth of N-ary Tree
这道题目思路和104差不多，区别就是我们不需要leftheight和rightheight，而是用一个for循环直接dfs

 for (Node child : root.children) { //replace left&right to for loop
            int value = maxDepth(child);
            
            if (value > max) {
                max = value;
            }

          最后返回 max+1;


733. Flood Fill
这道题目是典型的采用dfs解法的题目 具体的讲解可以参考花花的视频，非常清晰。

872. Leaf-Similar Trees
这道题目就是看所有的叶子是否相同，因此我们只要遍历到所有的叶子节点，查看val是否相等。
我们可以利用dfs 然后每到一个叶子节点(root.left==null&&root.right==null) 
我们利用一个StringBuilder对象sb.append(root.val+"-");
然后继续dfs(root.left,sb) ;
		dfs(root.right,sb);
		在主函数我们最后返回 sb1.toString().equals(sb2.toString());

98. Validate Binary Search Tree
这道题目用recursion 和 itrative 都行，但是我感觉两种方法都要注意 

itrative用前序遍历，另外用一个TreeNode pre的变量来保存上一个我们需要比较的结点


105. Construct Binary Tree from Preorder and Inorder Traversal
这个题的思路是： 由于preorder数组中第一个元素是根节点 因此可以通过preorder中第一个元素（即根节点）找到inorder中根节点的位置，找到后，inorder根节点左边就是左子树 右边就是右子树。此时我们再循环递归函数。
要注意的就是helper()函数中，对于preorder数组的索引只需要prestart，因为第一个元素就是根节点.
即每一个helper()函数中的根节点都是 TreeNode root=new TreeNode(preorder[prestart]);
而对于inorder的索引需要instart和inend。并且要十分注意生成左右子树传进去的函数变量

root.left=helper(prestart+1,instart,index-1,inorder,preorder);
root.right=helper(prestart+(index-instart)+1,index+1,inend,inorder,preorder);
				
106. Construct Binary Tree from Inorder and Postorder Traversal
思路同105一样，这一题我们会发现根节点总在postorder数组最后一个，前一个是右子树结点。

109. Convert Sorted List to Binary Search Tree
这道题目给了一个Linkedlist，我们的思路也是先找到中间的结点，然后以这个结点为根节点，左边为左子树，右边为右子树，我们也要定义一个dfs函数，函数的参数是 TreeNode head 和TreeNode tail 
并且初始传入的时候是 dfs(head,null)。
在dfs函数内部 我们要设置TreeNode fast =head;
					TreeNode slow=head;

			while(fast!=tail&&fast.next!=tail){
			fast=fast.next.next;
			slow=slow.next.next;
			}
			 TreeNode root = new TreeNode(slow.val);
			 root.left = dfs(head, slow);
        	 root.right = dfs(slow.next, tail);

        	 我自己感觉这里的while循环内条件容易弄错，我第一次写的时候直接是null。
        	 然后root.left=dfs函数中 tail的变量输入量是slow。
        	 	root.right=dfs函数中 head的变量输入量是slow.next;

 113. Path Sum II
 这道题目跟path sum差不多,注意的是除了题目所需要的List<List<Integer>> 
 我们还需要一个 List<Integer> templist 每遍历一个结点都要把root.val放入这个templist中
 当我们判断到(root.left==null&&root.right==null&&root.val==sum){
 		res.add(new ArrayList(templist));
 }else{
 			我们对左右子树进行dfs
 }	
 		回溯  templist.remove(templist.size()-1);


437. path Sum III
这道题目需要注意的就是要找到构成sum的所有数目即可 并且注意可以不从根节点开始
那么我们在主函数求解的时候就要调用自己 
return dfs(root,sum)+pathsumIII(root.left,sum)+pathsumIII(root.right,sum) 

114. Flatten Binary Tree to Linked List
这个题我们会发现 最后输出的树就是后续遍历相反的结果.
先初始化一个TreeNode prev变量
我们可以进行后续遍历，每次遍历到结点的时候：1.root.right=prev;
									2. root.left=null; 
									3. prev=root;
这道题目后续遍历然后去自己画一个图，思路就非常清晰


116. Populating Next Right Pointers in Each Node
等等 这好像是个BFS的题目啊
这道题目我们设置一个Levelstart来存储遍历的起始点,每次外层循环结束Levelstart=Levelstart.left
在内循环内，我们用 TreeLinknode cur 来进行操作.
		while(cur!=null){
                if(cur.left!=null)cur.left.next=cur.right;
                if(cur.right!=null &&cur.next!=null) cur.right.next=cur.next.left;
                cur=cur.next;
            }
            配合上图，很好理解这样的itrative代码

124. Binary Tree Maximum Path Sum
这道题目如果用一个类变量maxValue会比较好理解
在dfs函数中，我们对于要有 int left=Math.max(0,dfs(root.left));
					  int right=Math.max(0,dfs(root.right));
					  maxValue=Math.max(left+right+node.left,maxValue);
				注意要return的是 Math.max(left,right)+node.val;
		dfs函数代表了某一个结点的左子树路径和右子树路径取一个最大值

129. Sum Root to Leaf Numbers
这道题目我第一次做被trick到了，实际上用dfs也非常的容易。
只要一个结点是叶子 那么我们就返回 传入的sum+root.val
不是的话  我们返回dfs(左子树)+dfs(右子树)
		 注意dfs(root.left,sum*10+root.val); 

199. Binary Tree Right Side View
这道题目如果我们用dfs 因为题目要求的是从右面，因此我们可以从根节点开始，先遍历左右的右子树 
在 for循环内 如果i==size-1 说明该结点是该层最右的结点 我们就把该层添加进res
那么如果要求left view，我们就可以直接

200. Number of Islands 
利用dfs，思路是每次遇到grid[i][j]==’1‘,我们在该结点调用DFS方法，count++
意思是如果我们发现某个点是小岛，我们会不断的调用DFS方法，然后将所有靠近这个点的小岛”吃掉“。
最后返回的count 就是总共的岛屿数量

gird[i][j]=='0' 

207.  Course Schedule
这道题目可以看花花的视频 主要的思路是类似拓扑排序withDFS O(n)
要注意的是题目说 a graph is represented by a list of edges
根据pair来建立一个图的结构，用邻接链表来表示，还需要一个一位数组visited来记录某个节点是否被访问过，然后我们用DFS来搜索节点0，遍历的思想是，当DFS到某个节点，先看当前节点是否被访问过，如果已经被访问过，说明环存在，直接返回false，如果未被访问过，我们现在将其状态标记为已访问过，然后我们到邻接链表里去找跟其相邻的节点继续递归遍历

210. Course Schedule II
这道题目就是和207一样，唯一不同的就是题目要求我们返回一种可能的选课结果
因此我们新建一个res数组 可以考虑用一个类变量n。每次在dfs函数退栈后设置visited[cur]=2;
并且 res[n++]=cur;


337. House Robber III
这道题让我自己想还是思路不太清晰，虽然知道要利用动态规划。
可以看下篮子王老哥的视频，真的太厉害了！！一看就懂了！！

思路是利用动态规划 因为访问的是树，我们可以利用递归求解 helper函数返回的是一个数组
 res[0]代表不抢当前节点对应的房子有的最大值 res[1]代表抢当前节点对应房子有的最大值
 最后在主函数是返回 Math.max(res[0],res[1])。
 对于所有的子问题也是这样。 base case 是 if(root==null) return new int[2];
 对于每个节点我们有  int []left=helper(root.left);
 					int []right=helper(root.right);
 					之后 res[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
 					   res[1]=root.val+left[0]+right[0];
 			最后helper函数返回res

301. Remove Invalid Parentheses
看了花花酱的视频 但是写代码的最后碰到了问题
		如何在Java中实现 c++的erase功能呢 因为java中String是一个不可变类型
后来利用StringBuilder解决了！

323. Number of Connected Components in an Undirected Graph  

这道题让我们求无向图中连通区域的个数，LeetCode中关于图Graph的题屈指可数，解法都有类似的特点，都是要先构建邻接链表Adjacency List来做。这道题的一种解法是利用DFS来做，思路是给每个节点都有个flag标记其是否被访问过，对于一个未访问过的节点，我们将结果自增1，因为这肯定是一个新的连通区域，然后我们通过邻接链表来遍历与其相邻的节点，并将他们都标记成已访问过，遍历完所有的连通节点后我们继续寻找下一个未访问过的节点，以此类推直至所有的节点都被访问过了，那么此时我们也就求出来了连通区域的个数。

这道题目也可以利用union-find 


684. Redundant Connection
题目说的是新加的两条边能不能构成环,由于我学习了并查集 这道题目可以直接用并查集来解决。
思路：直接调用Union函数 如果(!Union) 说明两个点已经有相同的root，代表了已经可以构成环，说明这两个点重复了，是多余的，那么我们就返回两个点构成的数组。

547. Friend Circles
这道题和200题有点像 要找的就是图上连通着的1的块数
方法一 利用dfs 新建一个visited数组 visited[i]=0表示小伙伴还在，我们还没有访问。
	  visted[i]=1 表示小伙伴已经被访问过了。
不过做完后现在脑子还是有点迷糊

方法二 利用union-find 
	我们在union-find class中设置一个count变量 在构造函数中初始化count=n;
	每次我们完成union两个点时，把count--，代表独立的点减少了一个，这样就可以算出一共有多少
	个friend cycle.
	并且这个题目由于两个同学如果是friend是pair的关系
	在写循环时应该注意初始值内存循环的j从i+1即可	
			for(int i=0;i<n;i++){
				for(int j=i+1;j<n;j++){

				}
			}


99. Recover Binary Search Tree
不太懂怎么做，占着坑

366. Find Leaves of Binary Tree 
这道题换句话说就是找每个node的index，这个index就是最后结果中这个节点所在的list的index，比如4,5,3的index是0， 2的index是1，1的index是2.
怎么找呢？二分，看左，看右。
确定一个点的index，得知道他的左孩子index是多少，右孩子的index是多少，当前这个点的index是他左右孩子的index最大值+1，这可以很容易地观察得到。比如对于1来说，左孩子2的index是1，右孩子3的index是0，那1的index肯定是max(1, 0) + 1，即2.

417. Pacific Atlantic Water Flow
感觉有点奇怪，我总是在某个奇怪的地方卡主？？
在 dfs的函数里面不太理解  matrix[i][j] > matrix[x][y] 



329. Longest Increasing Path in a Matrix
这道题目看了花花酱的视频 瞬间懂了 这样前面那道洋流题目就懂了
唯一奇怪的是我按照花花酱的代码写的不能pass 一个test case
我感觉和最高赞那个代码是一模一样的


494. Target Sum
这道题目之前是用dp做，可能思路没那么明确
但是如果用dfs做，思路就可以非常的明确，用dfs尝试所有的可能 
如果 传入的参数 length==nums.length && 传入的值value==target

394. Decode String
这道题目如果用stack帮助会比较方便

364	Nested List Weight Sum II 
这道题目可以用dfs做，但是由于嵌套越深，权值越小，因此我们不能像 1那样每次就计算结果并且进行dfs
我们可以先遍历一遍NestList，拿到深度，保存在一个数组里。这样再进行第二次的遍历，就可以直接计算结果了

473. Matchsticks to Square
有点懵逼，可以用dfs做

513. Find Bottom Left Tree Value
dfs先序遍历，可以设置一个res数组存储h与val变量，每次发现depth>h的时候，那么就设置res[0]=root.val
这道题目看discuss好像用BFS更加好，到时候去看看

515. Find Largest Value in Each Tree Row
用dfs遍历，每次res.size()==depth的时候，先把res.add(root.val)
否则说明该层已经加了一个元素，需要把这个元素和已有的元素比较大小

128. LongestConsecutiveSequence
这道题目看花花的讲解 挺好的 主要思路是利用hashtable或者hashset 

226	Invert Binary Tree 
思路1.：左右交换结点，递归每一个子节点
思路2：利用BFS，每层判断

102. Binary Tree Level Order Traversal
思路：利用BFS 非常简单

103. Binary Tree Zigzag Level Order Traversal
思路：还是利用BFS 可以设置一个boolean类型的变量zigzag 每次在for循环的时候看zigzag是什么状态
如果是false 直接templist.add(node.val) 否则 逆序加入 templist.add(0,node.val) 

注意点：1.用BFS在for循环的时候，要先把int size=queue.size()拿出来，用size放到循环内(这样实际上在CMU15213中提到是对程序的优化)
      2.这个题目要先 TreeNode node=queue.poll() 不能最后再poll; 因为我们会存在逆序加入的情况


111. Minimum Depth of Binary Tree
这个题和最大depth of binary tree很像 
不过这个题目我个人感觉如果用递归的话，比较容易错误，要在每一层进行判断
 还是利用BFS比较好

994. Rotting Oranges
这个题目也挺有意思的 利用BFS

279. Perfect Squares
这道题目利用BFS也可以做 

286. Walls and Gates  
BFS和DFS都可以做 熟了之后看答案感觉一看就懂了，不过自己写还是有地方容易出错。

490. The Maze 
思路 BFS and DFS

499. The Maze II
思路 BFS and DFS

513. Find Bottom Left Tree Value
思路：之前用dfs 
现在用的是BFS 1.直接从右边traverse 2.从左边traverse 做一个判断 i==0的时候 res=node.val;

515. Find Largest Value in Each Tree Row
思路:BFS

559. Maximum Depth of N-ary Tree
思路:BFS

542. 01 Matrix
思路： BFS  
前置操作：一开始遍历数组的元素，我们把值为0的下标offer入队列，元素是1的话直接把该格子的值设置为
Integer.MAX_VALUE; 
然后开始遍历，主要注意的地方是在改变方向的loop中 
       if(x<0||x>=m||y<0||y>=n||matrix[x][y]<=matrix[cell[0]][cell[1]]+1)continue;
       最后面除了保证最小条件，还保证了不会将0的地方压入队列，这样只会将一些边界处的0压入队列。

863. All Nodes Distance K in Binary Tree
思路：graph + BFS
可以把这个树看成是一个无向图，除了叶子节点以及根节点，其他节点与3个节点相连。
我们可以把这个graph关系利用HashMap来保存。 之前记得好像有个题是Course Schedule 
是利用List保存的。

4.16
787. Cheapest Flights Within K Stops
思路：可以利用Dijkstra算法  Dijkstra主要的思路是利用priorityQueue


297.Serialize and Deserialize Binary Tree
思路：  serialize的时候用一个StringBuilder不停的appendhhhh 
		deserialize可以把data放入一个queue中 利用 q.addAll() 与Arrays.asList(data.spilt)方法形成一个个的数放入q中。
		在helper函数中 每次要 q.remove()掉一个数 

652. Find Duplicate Subtrees    
不知道为什么我用StringBuilder通不过


222. Count Complete Tree Nodes
就是dfs一下 感觉没什么难的

4.17
255. VeriPreorderSequenceinBinarySearchTree
注意一下这个题目的意思是 给你一个数组判断这个数组是不是二叉树的前序遍历输出
我们会发现一个有意思的现象，对于符合条件的数组，在第一个数，一定是先一直下降后一直上升的。
通过这个性质我们可以用一个stack帮助我们判断

501. Find Mode in Binary Search Tree
思路1：遍历所有的结点 把对应的node值放入map中，同时存一个global变量max记录 对应node.val为key时最大的value值，最后在主函数里面查找这个value，返回key值，加入res的list

follow up:由于要用constant space 于是我们不能用hashmap来帮助我们存储数据

508. MostFrequentSubtreeSum
和501题类似，我们采用postorder 计算sum，然后利用hashmap保存结果
最后再主函数查找

606. Construct String from Binary Tree
初次做感觉有点难，其实还是比较简单的。明天早上做反过来的！！
第二次做感觉好一些，但是还是要看别人的solution才能写出来

4.18 


536. ConstructBinaryTreefromString
第一次刷感觉还是有点难 看了网上的某个思路，是这样的：
这道题让我们根据一个字符串来创建一个二叉树，其中结点与其左右子树是用括号隔开，每个括号中又是数字后面的跟括号的模式，这种模型就很有递归的感觉，所以我们当然可以使用递归来做。首先我们要做的是先找出根结点值，我们找第一个左括号的位置，如果找不到，说明当前字符串都是数字，直接转化为整型，然后新建结点返回即可。否则的话从当前位置开始遍历，因为当前位置是一个左括号，我们的目标是找到与之对应的右括号的位置，但是由于中间还会遇到左右括号，所以我们需要用一个变量cnt来记录左括号的个数，如果遇到左括号，cnt自增1，如果遇到右括号，cnt自减1，这样当某个时刻cnt为0的时候，我们就确定了一个完整的子树的位置，那么问题来了，这个子树到底是左子树还是右子树呢，我们需要一个辅助变量start，当最开始找到第一个左括号的位置时，将start赋值为该位置，那么当cnt为0时，如果start还是原来的位置，说明这个是左子树，我们对其调用递归函数，注意此时更新start的位置，这样就能区分左右子树了

653. Two Sum IV - Input is a BST
可以用一个hashset来存储每一个结点的值，每次在子函数中都查找set.contains(k-root.val)，如果有，就可以直接return true

889. Construct Binary Tree from Preorder and Postorder Traversal
这个题目和前面两个题目基本一样，我们可以知道三个遍历方式是这样的

		  1
	  2      3
	4   5   6   7
前序遍历：root(left)(right)	1245367
中序遍历:（left)root(right)	4251637
后续遍历：(left)(right)Root  4523671

在前序遍历中的数组中，第一个点是根节点，后面一个点就是左结点。我们根据这个左结点的值
去后续遍历的数组中查到的索引就是根节点对应左子树的右边界
这个题目并且要注意base case 我们传入preStart preEnd postStart postEnd 这个几个索引用来帮助我们不断递归循环生成root与 root.left root.right
base case我们只需要 1.preStart>preEnd return null  
					2. preStart==preEnd return new TreeNode(pre[preStart];
	并且注意的是每次在root.left与root.right的时候 要注意更新索引的值

654. Maximum Binary Tree
这个题目如果简单想可以直接用recusion 每个函数中先找到最大的值，然后在这个结点去递归生成左子树和右子树
有个O(n)的方法是利用stack，这个方法具体的原理我还是不太懂

298. Binary Tree Longest Consecutive Sequence 
思路：dfs函数 每次传入TreeNode、curmax、target值 

4.19
662. Maximum Width of Binary Tree  ???
这个题第一遍做没有太看懂，网上也没找到视频，到时候和同学讨论一下吧


669. Trim a Binary Search Tree
看花花的视频就听懂了 花花牛皮（破音）

4.20
687. Longest Univalue Path
自己第一次做还是做不出来，我日
要看花花的视频，发现我题目的意思也没有完全的理解。这里面需要一个全局变量ans保存最大的路径，并且在helper函数的返回值需要非常注意，
ans=Math.max(ans,pl+pr);
由于只能返回一个路径 所以是 return Math.max(pl,pr);

814. Binary Tree Pruning
思路 利用dfs 我们直接考虑从叶子节点开始删除， 如果是叶子节点，并且val==0,那么可以直接return null
我一开始想着从up着手，就不太好处理。
第二次做，还是有点懵逼啊，果然这种recursive的解法就是容易原地爆炸。

958. Check Completeness of a Binary Tree
思路：利用BFS 这里的while循环退出的条件是q.peek()==null&&!q.isEmpty() 退出循环后，如果树是不全树，此时queue中还有不是null的结点。
我们做一个判断  当queue不为空并且q.peek()==null的时候 q.poll()  最后返回 q.isEmpty();
第二次做：一开始有点懵逼，看了思路一下就懂了

951. Flip Equivalent Binary Trees
我们要注意的是这道题目说的是有可能只换某两个节点，不一定全部都换。

865. Smallest Subtree with all the Deepest Nodes
看花花的视频吧 牛逼 真的讲的好

这三天打算把hashtable的tag刷一遍

451. Sort Characters By Frequency
一开始先创建一个map，建立字符char和数字（即出现次数频率）的映射
由于这个题目说相同频率的可以任意位置，因此我们可以
再创建一个 List<Character>bucket数组是一个关键， 根据字符出现次数创建arraylist，加入字符
最后利用一个pos索引 从bucket的末端索引开始（对应频率高的字符），利用StringBuilder重建字符

4.21

463. Island Perimeter
这道题目说是用hashtable 实际上不需要用hashtable 
我们可以考虑这样的数学事实：当一个面积旁边有一个邻居，那么他对整个周长的贡献就会减少1。因此我们的思路
就是遍历所有的格子，当发现是岛屿的时候area++ 并且判断存在几个邻居 neibor++
最后返回 area*4-neibor
improve：我们可以只判断单边，利用对称性，最后返回area*4-neibor*2

500. Keyboard Row
这道题目就可以利用hashtable了 
将一行上的数字都存进hashtable里面 对应一个Integer的行号
然后

594. Longest Harmonious Subsequence
先用one pass hashtable记录每个数字的频率
再 one pass 如果map.containsKey(key+1)就用result记录最大值 result=Math.max(result,map.get(key+1)+map.get(key))

525. Contiguous Array
看花花的视频 花花niubility 
总的思路就是 prefix sum+ hashtable 降低原本二次甚至三次的时间复杂度

560. Subarray Sum Equals K
这道题其实花花讲的不是那么明白，感觉用的例子和ppt没那么好了
这道题其实就是525的转化版本，不同的是这里要寻找k 因此我们在利用hashtable应该判断
contains(presum-k)。。


554. Brick Wall
我们用hash表建立断点与频率的映射，所以我们只要找到出现断点频率最多的地方断开就能损坏最小的砖。

76. Minimum Window Substring
利用hashtable +利用two pointer +sliding window  可以看看来offer的视频讲的不错
key:t中的字符
value:搜索字符串中出现的频率

4.22
今天做到很多题目都要用Trie这个数据结构，那么今天把Trie的tag的题目刷一些吧

648. Replace Words
典型的用Trie题目 不过里面的很多函数的小细节需要去注意一下
还有一点我不太懂最高的upvote的地方在于，为什么他new 一个TrieNode的时候要添加' '

211. Add and Search Word - Data structure design
这个题目给出一个.可以代替所有的字母。现在看到这种题目有时候不知道怎么讲比较好了嗷


720. Longest Word in Dictionary
论坛上的高分解法的思路其实我们只要给数组排个序，就可以使用贪婪算法来做了，并不需要什么DFS或BFS这么复杂。首先建立一个空的哈希set，然后我们直接遍历排序后的字典，对于当前的单词，如果当前单词长度为1，或者该单词去掉最后一个字母后在集合中存在，这也不难理解，长度为1，说明是起始单词，不需要的多余的判断，否则的话就要判断其去掉最后一个字母后的单词是否在集合中存在，存在的话，才说明其中间单词都存在，因为此时是从短单词向长单词遍历，只要符合要求的才会加入集合，所以一旦其去掉尾字母的单词存在的话，那么其之前所有的中间情况都会在集合中存在。我们更新结果res时，要判断当前单词长度是否大于结果res的长度，因为排序过后，默认先更新的字母顺序小的单词，所有只有当当前单词长度大，才更新结果res，之后别忘了把当前单词加入集合中



347. Top K Frequent Elements
时间复杂度最低的方法是利用桶排序。可以看下花花的视频

692. Top K Frequent Words
思路1：用 hashmap+trie+bucket sort  
我看了答案 感觉还是有点怪怪的，明天再看吧，今天太累了

4.23

23.Merge k Sorted Lists
可以利用pq 最小堆进行排序，第一次做看的是王子蓝老哥的视频，感觉不错，这个方法的
时间复杂度是O(nklogk) 一共有nk个元素，每次插入pq需要花费logk代价
空间复杂度是O(k) 就是lists放入pq的length

32. Longest Valid Parentheses
主要思想是利用辅助  当一个字符是'('我们就把此时
这个字符的索引放入stack中，当一个字符时')' ，我们首先要看看stack是不是空，是空的话说明前面没有'('我们要把i赋予给leftmost,不为空我们再把前面一个的元素的索引pop出来，此时还要判断stack是不是空 ，是空的话 max=Math.max(max,i-leftmost) 不为空 max=Math.max(i-stack.peek());

45. Jump Game II
类似贪心的算法，我们每次在可跳范围内选择可以使得跳的更远的位置， 一旦遇到边界，就更新边界，并且步数加一
	
41.First Missing Positive  
这道题目高亮解法是可以如果我们找到一个数字5 那么我们把5 与nums[4]交换，简而言之，就是把数字都放在他们应该在的位置 最后我们再重新遍历一遍数组
如果发现nums[i]!=i+1，说明这个位置的元素少了，return i+1

25. Reverse Nodes in k-Group
这道题目一开始听王子蓝老哥说可以利用stack,思路也非常的简单，容易理解。每次都把k个数字push进入stack，然后再拿出来连接。然而这样时间复杂度O(k）不满足lc的要求
然后可以用constant space，我们可以自己写一个exchange函数，
基本的思路就是每次把后面一个结点放到最前面。思路可以看下王子蓝老哥视频


42. Trapping Rain Water
看看王子蓝老哥的视频吧，讲得不错，论坛高分的vote也是这个方法

43. Multiply Strings
论坛高分vote讲的可以了，好好理解一下

10. Regular Expression Matching
这道题是字符串匹配问题，王子蓝老哥提到两个字符串匹配问题考虑用dp解决

44. Wildcard Matching
这道题目和👆一道题目是一样的，好好注意 

57. Insert Interval
思路：我们要找 插入点的start小于原段的end 与插入点的end大于原段的start的最大段

146. LRU Cache
这个题目是设计一个数据结构的题目

135.Candy
先从左到右扫描一遍，使得右边比左边得分高的小朋友糖果数比左边多。
再从右到左扫描一遍，使得左边比右边得分高的小朋友糖果数比右边多

4.25
115. Distinct Subsequences
和10.44题类似 利用dp 关键是找出转移状态方程和初始化的条件
这道题的转移状态方程不是很好想
网上说可以通过填表的方式来找到规律？
变换方法等于保留这个字母的变换方法加上不用这个字母的变换方法。


136. Single Number
异或有一个性质：a^a^b=b 因此这个题目我们初始化result=0，不断去异或数组中的元素，最后剩下的就是只出现一次的元素

165. Compare Version Numbers
刘凯宁学长的第一轮面试题 在这里碰到了？？ 
先用String.spilt("\\.")分割成数组，然后利用 Integer.parseInt函数 
比较可以利用 Integer.compareTo()方法.

168. Excel Sheet Column Title
最容易忽视的地方在于代码中的n-- 以及 sb.append((char)('A'+n%26));
为什么要n--，取余的时候又是取26呢，因为我们是以A作为参照的，A代表的数字是1。举个例子
输入的数字是26，此时应该输出z，z相对于A是在1右边的25位索引。

179. Largest Number
这个题目要用到 comparator类和 Arrays.sort方法 这两个点我有点不太清晰，之后看sc61b的时候要好好注意一下

201.Bitwise AND of Numbers Range
第一次做 这道题目都没太看懂，看了别人的解释，是说要返回所有区间内数字的 与操作的结果
如果我们暴力的直接所有数字直接相与，那么这种算法会超时，通不过lc。
于是我们要优化我们的算法。下面是lc高vote思路：
1.last bit of (odd number & even number) is 0.
2.when m != n, There is at least an odd number and an even number, so the last bit position result is 0.
3.Move m and n rigth a position.

223. Rectangle Area
一刷：
这个题估计也没人会考吧 先计算单独的面积 然后计算是否有重叠，有重叠减去重叠的面积

224. Basic Calculator
我感觉这种calculator题目都可以用stack辅助解题了

228. Summary Ranges
由于数组的元素已经给我们排序好了，那么我们的解决方法非常的直接
利用for循环遍历数组的元素  
我们先取出元素 int a=nums[i] 当我们发现 i+1<nums.length&&nums[i+1]-nums[i]==1时 
我们直接让i++
一旦退出循环说明此时已经不是连续的range了
我们做一个判断，如果 a！=nuns[i] 说明i已经被++了，此时我们 list.add(a+"->"+nums[i]);
否则我们直接 list.add("a");


231. Power of Two
解法1：对n不断的取余 当 n%2==0 n/=2; 最后返回 n==1;
解法2：下面是以2为底的指数的二进制表示，我们发现最高位都是1
1     2       4         8         16 　　....

1    10    100    1000    10000　....

如果我们把他减一会发现 除了最高位其他位都变成了1 
因此如果 n&(n-1)==0 那么这个数就是以2为底的指数

239. Sliding Window Maximum
这个题目用brute force也是可以通过的，当k=n/2时，时间复杂度就变成O(n^2)了。
论坛上高vote采用了deque 思路如下：

At each i, we keep "promising" elements, which are potentially max number in window [i-(k-1),i] or any subsequent window. This means

If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head, as we are using a deque and elements are ordered as the sequence in the array

Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any other subsequent window: a[i] would always be a better candidate.

As a result elements in the deque are ordered in both sequence in array and their value. At each step the head of the deque is the max element in [i-(k-1),i]

241.Different Ways to Add Parentheses
可以看下花花的思路 我怎么感觉贼难啊这种题，完全自己做不出来，心酸


4.27

260. Single Number III
看下这个网址的解析，非常详细了
https://segmentfault.com/a/1190000004886431

295. Find Median from Data Stream
这个题感觉不错 思路就是用两个priority queue，一个最大堆实现，一个是最小堆实现
最大堆的元素都排在左边，最小堆的元素排在最大堆元素的右边。

282. Expression Add Operators
看了花花的视频 再看代码还是有点模糊，我觉得明天要再来看一遍视频，然后跑一个代码分析一下。

4.28

289. Game of Life
高分vote真是一个天才啊！！！利用2位bit存储状态 利用右移转换状态！niubility

303. Range Sum Query - Immutable
这道题目要求设置的这种数据结构是查询某段下标具体值的数字和
那我们构建这种数据结构的时候就可以利用累加法，初始化 int []sum=new int[nums.length];
每次循环的时候 sum[i]=num[i]+ ((i>0)? sum[i-1]:0);
最后去取数值的时候 返回 (i==0)?sum[j]-sum[i]:sum[j];

304. Range Sum Query 2D - Immutable
这道题目变成了2d的图 我们可以构建一个2D array sums[row+1][col+1] 代表从0到 row行 col列的数字和
注意：这里我们增加了额外的空白row和col sums[0][col+1]={0}和sums[row+1][0]={0}
可以避免check edge case
构建的算法核心就是 sums[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+matrix[i-1][j-1]
最后计算结果的时候 也是这个想法        
return sums[row2+1][col2+1] - sums[row2+1][col1] - sums[row1][col2+1] + sums[row1][col1];

307. Range Sum Query - Mutable



342. Power of Four
又是一个类似 bitmanipulation的题目 
我们可以观察到4的倍数的特点是
1.数字大于0
2.二进制表达只有一个1
3.1在奇数位置
因此我们可以利用 num&(num-1)==0 判断是否二进制表达式中只有一个1
并且 将num与0x55555555（1010101010101010101010101010101的16进制表达）看这个1是否在奇数位置

345. Reverse Vowels of a String
可以用一个String对象的变量 vowel="aeiouAEIOU"作为我们的字典，
设置left=0与right=s.length()-1 两个pointer  并且将s转化为charArray
我们利用 vowel.indexOf()方法判断 charArray中的元素，当charArray中的字符不为元音我们就让指针不断的移动
当两个指针都停下后，我们交换left与right所在

307. Range Sum Query - Mutable
可以用 binary indexed tree解决问题，看下花花的视频吧，第一次做搞了好久才想懂

315. Count of Smaller Numbers After Self
这道题目也是利用binary indexed tree ，因为这种数据结构可以相对高效的帮我们计算prefix sum。
本题经过两次转换的思维，我们可以变成求prefix sum 
首先要把数组排序 并且去除重复元素得到对应的rank加入一个map中 
然后我们对数组进行逆序的循环操作，这里逆序的原因可以看花花的视频，配上图解
在循环中，

4.29 

318. Maximum Product of Word Lengths
利用bit manipulation 核心的代码是
value[i]|=1<<(temp.charAt(i)-'a'); 对每个字符串进行二进制表达式的赋值
赋值完毕后 如果发现 value[i]&value[j]==0 说明这两个字符串不含有相同的字符

331. Verify Preorder Serialization of a Binary Tree
这个题目的高分vote利用了性质去判断是不是一个binary tree
1.all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
2.all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
因此我们可以初始化一个diff变量=1 遍历所有的node，进入循环diff--（代表所有的node都有一个parent）如果diff<0的时候直接return false; 
再判断如果node不为# diff+=2（代表此时非空的结点提供2个孩子）

343. Integer Break
我感觉这就是一个math的题目 首先6=3+3或者6=2+2+2 然鹅3*3>2*2*2 因此我们把输入的n每次减3
然后factor*3，最后当n不大于4的时候，直接让factor*n就可以返回得到我们的factor结果
具体为什么可以看看上面的discuss

72. Edit Distance
dp的思想 花花一开始用了递归的思路 论坛里的人都利用递推

6. ZigZag Conversion
看下王子蓝老哥的视频


125. Valid Palindrome
two pointer+Character.isLetterOrDigit方法 如果返回false 那么对应的i++ 或者j--
目的是跳过空格以及一些标点  最后判断两个字符是不是相同，注意大小写是算作同样的字符，因此我们要用到Character.toLowerCase，一旦不相同就返回false；
循环结束后，表示我们没有找到不相同的，return true。


680. Valid Palindrome II
emmm 还好吧，不知道怎么写思路了，利用两个指针就好了

130. Surrounded Regions
这道题目用dfs做，思路是从四条边上进行dfs 把O全部变为*，要注意的地方是
如果对某两条边进行dfs后，另外两条边的dfs要减去4个点
即 for(int j=1;j<n-1;j++)

134. Gas Station
这道转圈加油问题不算很难，只要想通其中的原理就很简单。我们首先要知道能走完整个环的前提是gas的总量要大于cost的总量，这样才会有起点的存在。假设开始设置起点start = 0, 并从这里出发，如果当前的gas值大于cost值，就可以继续前进，此时到下一个站点，剩余的gas加上当前的gas再减去cost，看是否大于0，若大于0，则继续前进。当到达某一站点时，若这个值小于0了，则说明从起点到这个点中间的任何一个点都不能作为起点，则把起点设为下一个点，继续遍历。当遍历完整个环时，当前保存的起点即为所求。代码如下：

530. Minimum Absolute Difference in BST
因为是一个BST树，因此我们只需要中序遍历，每次比较两个节点，找出差值最小的就可以了
如果不是一个BST，那么可以遍历所有的结点，然后存储下来，做一个排序，再做一个O(n)的onepass就可以

783. Minimum Distance Between BST Nodes
这个题和530难道不是一样的吗

938. Range Sum of BST
这道题目看起来很简单 应该用递归 但是递归就是自己写不出来啊，好难受啊

2019/9/11
538.Convert BST to Greater Tree
emmmmm 又是递归的题目，自己写还是不能很快的sovle，又看了答案
