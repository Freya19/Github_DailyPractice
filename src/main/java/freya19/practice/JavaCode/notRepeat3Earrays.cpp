/*
�������һ�����ظ������飬��[1,2,3,4,5,6,7,8,9,11,14,16,12,19] �������1000����Ԫ�飬Ԫ����Ԫ�ز��ظ�
�磺[1,3,5]
*/
#include <iostream>
using namespace std;

int notRepeat3Earrays(int array[],int length) {
	if (length != 0) {
		int interval = length / 3;//����ż��������
		int l = 0;
		int m = l + interval;
		int r = m + interval;
		int nums[] = {};
		while (l < m && m < r) {
			nums[3] = {array[l],array[m],array[r]};
			l++;
			m++;
			r++;
		}
	}else
		return 0;	
}

int main() {
	//int ret = 11 / 2;
	//cout << ret << endl;
	int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 14, 16, 12, 19 };
	int length = sizeof(arr) / sizeof(int);
	cout << length << endl;
	//notRepeat3Earrays(arr,length);

	system("pause");
	return 0;
}




























