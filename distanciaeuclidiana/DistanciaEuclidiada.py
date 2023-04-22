import math


def circulo_minimo():
    while True:
        n = int(input())
        if n == 0:
            break

        # le as coordenadas dos integrantes
        coords = []
        for i in range(n):
            x, y = map(float, input().split())
            coords.append((x, y)) # adicionar as coordenadas no mapa

        # encontrar o par de pontos mais distantes
        max_dist = 0
        p1 = None
        p2 = None
        for i, pi in enumerate(coords):
            for pj in coords[i+1:]:
                distancia_euclidiana = math.sqrt((pi[0]-pj[0])**2 + (pi[1]-pj[1])**2)
                if distancia_euclidiana > max_dist:
                    max_dist = distancia_euclidiana  # Salva maior distancia
                    p1 = pi                          # Salva ponto A
                    p2 = pj                          # Salva ponto B

        # encontra o ponto médio entre os dois pontos mais distantes
        center_x = (p1[0] + p2[0]) / 2
        center_y = (p1[1] + p2[1]) / 2

        # encontra o raio da circunferência
        radius = max_dist / 2

        # imprimi a saída com duas casas decimais
        print(f"{center_x:.2f} {center_y:.2f} {radius:.2f}")


# Distancia Euclidiana
# https://www.youtube.com/watch?v=URZbBqc4U4o

if __name__ == '__main__':
    circulo_minimo()