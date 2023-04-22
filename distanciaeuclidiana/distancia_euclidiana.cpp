#include <iostream>
#include <cmath>

using namespace std;

const int MAXN = 100;

struct Point {
    double x, y;
};

int main() {
    int n;
    Point p[MAXN];
    while (cin >> n && n) {
        for (int i = 0; i < n; i++) {
            cin >> p[i].x >> p[i].y;
        }
        double cx = 0.0, cy = 0.0;
        for (int i = 0; i < n; i++) { // Soma todos os pontos x, y
            cx += p[i].x;
            cy += p[i].y;
        }
        cx /= n; // calcula media da soma dos pontos x
        cy /= n; // calcula media da soma dos pontos y
        double r = 0.0;
        for (int i = 0; i < n; i++) {
            double d = sqrt(pow(p[i].x - cx, 2) + pow(p[i].y - cy, 2)); // maior distancia euclidiana com base nas medias
            r = max(r, d); // Salva o maior raio
        }
        cout.precision(2);
        cout << fixed << cx << " " << cy << " " << r << endl;
    }
    return 0;
}
