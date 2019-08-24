# easyCRUD
ZADANIE 3
Zbudować prostego CRUD’a. Dla tabeli ksiazka należy zrobić:
1. obiekt DAO który będzie miał funkcje CRUDA:
• funkcję do czytania danych dla zadanego id (findById())
• funkcję dodawania nowej książki (newBooks())
• funkcję modyfikacji książki o zadanym id (updateById())
• funkcję usunięcia książki z konkretnym id (deleteById())
2. dodatkowo obiekt DAO będzie miał funkcję do pobierania listy wszystkich książek.
3. W funkcji main() korzystając z obiektu DAO tabelki ksiazka robimy operacje:
a. wczytujemy listę książek i wyświetlamy ją na ekranie
b. dodajemy 4 nowe książki
c. wczytujemy ponownie listę książek i wyświetlamy ją na ekranie
d. modyfikujemy ostatni rekord w bazie z książkami wstawiając w pole nazwa książki „nakład wyczerpany” (pobieramy ostatni index Selectem z funkcją sql MAX na kolumnie id)
e. wczytujemy ponownie listę książek i wyświetlamy ją na ekranie
f. usuwamy ostatni rekord
g. wczytujemy ponownie listę książek i wyświetlamy ją na ekranie
4. wrzucamy dane z połączeniem do bazy w osobną klasę DBProperties i korzystamy z niej w naszym programie.

-----------------------------------------------------
ZADANIE 4
• Dodać nową książkę za pomocą DAO z poprzedniego zadania
• Dodać autora książki dodanej w poprzednim podpunkcie i powiązać ich w bazie danych (za pomocą tabeli łączącej autor_ksiazka). Wszystko robimy za pomocą dedykowanych obiektów DAO.
• Dla DAO autor zwracamy listę książek których jest autorem, lub współautorem.
• Dla DAO autora dodajemy funkcję sprawdzającą czy dany autor napisał książkę o zadanym tytule.
