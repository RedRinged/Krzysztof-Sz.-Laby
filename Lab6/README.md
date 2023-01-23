# Game_of_life
## Patryk Popławski 82668
 
### Biblioteka MPI
### Używany Google Collab oraz visual S 

# Funkcja main rozpoczyna się od tworzenia zmiennej suma, która jest używana do przechowywania sumy iteracji. Następnie inicjalizuje MPI i ustawia liczbę iteracji na DEFAULT_ITERATIONS, jeśli nie zostanie podana żadna inna liczba.

# Następnie, kod inicjalizuje zmienne MPI, takie jak num_procs (liczba procesów), ID (identyfikator procesu) i iters (liczba iteracji).

# Następnie, kod rozpoczyna pętlę iteracji, w której przetwarza siatkę przy użyciu reguł gry w życie i przesyła dane między procesami za pomocą MPI. Po zakończeniu pętli iteracji, kod kończy pracę MPI i zwraca sumę iteracji.

