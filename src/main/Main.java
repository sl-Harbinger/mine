package main;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("ВВедите размеры поля через пробел");
        int m = sc.nextInt();   //сканирование m
        int n = sc.nextInt();//сканирование n
        System.out.println("Введите количество мин");
        int k = sc.nextInt();//сканирование k кол-во мин
        StringBuilder qq = new StringBuilder(); //стоковые переменные
        if (k != 0) { // если есть мины
            System.out.println("Введите координаты мин через пробел");
            int[][] a = new int[m + 2][n + 2]; // матрица +2 для простоты записи соседей
            //сканирование координат мин присвоение мине значения 100 определение соседей
            for (int i = 0; i < k; i++) {
                int y = sc.nextInt();
                int x = sc.nextInt();
                a[y - 1][x - 1]++;
                a[y - 1][x]++;
                a[y - 1][x + 1]++;
                a[y][x - 1]++;
                a[y][x] = 100;
                a[y][x + 1]++;
                a[y + 1][x - 1]++;
                a[y + 1][x]++;
                a[y + 1][x + 1]++;
            }
            //печать поля мин с соседями
            for (int i = 1; i < m + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (a[i][j] > 99) { //замена значения 100 на m
                        qq.append("m").append(" ");
                    } else {
                        qq.append(a[i][j]).append(" ");
                    }
                }
                System.out.println(qq.toString().trim());
                qq = new StringBuilder();
            }
        } else { //печать если мин нет
            int[][] arr = new int[m][n]; //создание матрицы по m и n
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    qq.append(arr[i][j]).append(" ");
                }
                System.out.println(qq.toString().trim());
                qq = new StringBuilder();
            }
        }
    }
}
