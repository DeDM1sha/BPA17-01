/* HackerLand National Bank имеет простую политику предупреждени¤ клиентов о 
	 * возможных мошеннических действи¤х на счете. ?сли сумма, потраченна¤ клиентом 
	 * в определенный день, больше или равна медиане расходов клиента за конечное 
	 * число дней, они отправл¤ют клиенту уведомление о потенциальном мошенничестве.
	 * Ѕанк не отправл¤ет клиенту никаких уведомлений до тех пор, пока у него нет, 
	 * по крайней мере, этого конечного числа транзакций за предыдущие дни. ”читыва¤ 
	 * количество завершающих дней и общие ежедневные расходы клиента за период, 
 	 * найдите и распечатайте количество дней, когда клиент получит уведомление.
	 *
	 * 1 <= n <= 2*10e5, n - количество учтенных расходов 
	 * 1 <= d <= n, d - количество дней дл¤ расчета медианы
	 * 0 <= exp[i] <= 200
	 *
	 * ѕример: 9 5
	 *	   2 3 4 2 3 6 8 4 5
	 * ќтвет: 2
	 * {2 2 3 3 4}, m = 3, 2 * 3 <= 6  1
	 * {2 3 3 4 6}, m = 3, 2 * 3 <= 8  1
	 * {3 3 4 6 8}, m = 4, 2 * 4 > 4   0
	 * {3 4 4 6 8}, m = 4, 2 * 4 > 5   0

	 * ѕример: 5 4 
	 *	   1 2 3 4 4
	 * {1 2 3 4}, m = 2.5, 2 * 2.5 > 4 0
	 * ќтвет: 0
	 */
import 'dart:io';
import 'dart:core';

void main() {
  int n;
  int d;
  int result = 0;
  double m;
  List<int> array;
  bool check;
  int index;
  // List ch = new List(50000);
  // print(ch);
  // Синхронное открытие файла
  List<String> input = new File('D:/GitHub/BPA17-01/18/file.txt').readAsLinesSync();

  // Считывание данных с файла
  n = int.parse(input[0].split(' ')[0]);
  d = int.parse(input[0].split(' ')[1]);
  array = input[1].split(' ').map(int.parse).toList();
  // print(n.toString() + ' ' + d.toString());
  // print(array);
  // print('');
  // Основной цыкл программы
  // print('ok');
  for (int i = 0; i < (n-d); i++) {
    check = false;
    List<int> temp = array.sublist(i, i+d); // Создаём дубляж массива от i до i+d
    temp.sort(); // Сортируем массив по возрастанию.
    index = (d/2).round();
    (d % 2 == 1) ? { index-=1, m = temp[index].toDouble()} : m = (temp[index--] + temp[index])/2;
    
    // m = temp.fold(0, (previous, current) => previous + current) / temp.length; // складываем все значения и делим на их кол-во
    (2 * m <= array[d + i]) ? {result++, check = true} : null; // Проверка по формуле
    // print(temp.toString() + ', m= ' + m.toString() + ', 2* ' + m.toString() + ' <= ' + array[d + i].toString() + ' ' + check.toString());
    // print('ok');
  }
  print('Ответ: ' + result.toString());
  // 9 5
  // [2, 3, 4, 2, 3, 6, 8, 4, 5]

  // [2, 2, 3, 3, 4], m= 3.0, 2* 3.0 <= 6 true
  // [2, 3, 3, 4, 6], m= 3.0, 2* 3.0 <= 8 true
  // [2, 3, 4, 6, 8], m= 4.0, 2* 4.0 <= 4 false
  // [2, 3, 4, 6, 8], m= 4.0, 2* 4.0 <= 5 false
  // Ответ: 2
}
