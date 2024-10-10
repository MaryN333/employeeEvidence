Evidence zaměstnanců

**Opakování: Reprezentace osob**
﻿

Vytvoř třídu Person pro reprezentaci osob v přístupovém systému firmy.

O každé osobě chceme evidovat tyto údaje:

- ID … celé číslo
- jméno (name)
- příjmení (surname)
- aktuální stav konta v interním platebním systému pro stravování (account)
- informaci, jestli se jedná o zaměstnance (is employee), nebo jinou osobu (externista, host,...)
- počet tiketů (počet hlášených podnětů ve firemním systému pro zlepšování)(tickets) Volitelně můžete přidat druhý konstruktor, který nastaví výchozí hodnotu na 0.
- datum posledního příchodu do práce (last arrival) Výchozí hodnota bude datum vytvoření objektu (aktuální datum).
- tělesnou teplotu při posledním příchodu do práce (měří se jako prevence nemocnosti)(body temperature) Výchozí hodnotu nastav na -300. Bude se nastavovat až při prvním příchodu do práce.
﻿

Můžeš vyzkoušet také automatické přiřazování ID pomocí třídního (static) atributu nextId.

**Opakování: Ruční práce se seznamem osob**
- Vytvoř seznam osob a vlož do něj ručně tři osoby.
- Přidej dalších 20 osob, kde bude jako jméno použito číslo 1..20 a jako příjmení text "guest". Stav konta bude 300 Kč. Jsou to hosté — nejedná se o zaměstnance a nebudou mít žádné tikety.
- Vypiš počet osob v seznamu.
- Zapiš kód, který vypíše:

-křestní jména všech osob,

-křestní jména všech zaměstnanců (nikoli hostů),

-u křestního jména vypíše "host" nebo "zaměstnanec",

-Před každým jménem vypíše jeho pořadové číslo ve výpisu.


**Třída s opakovaně použitelnými metodami**
﻿

Připrav třídu TimeClocksWorker, ve které připravíme metody pro práci se seznamem osob. Bude mít seznam osob jako atribut.


Připrav metody pro:

-přidání jedné osoby

-přidání seznamu osob v jednom kroku

-zjištění počtu evidovaných osob
﻿

Zařaď do seznamu osoby z našeho ručně vytvořeného seznamu.

**Úkoly 1**

-Připrav metodu, která spočítá průměrný počet tiketů na osobu (všechny typy osob).

-Připrav metodu, která najde první osobu s počtem ticketů vyšším než zadaný parametr.

Úkoly 2

-Připrav metodu, která spočítá počet hostů v seznamu (zaměstnance nepočítá).

-Připrav metodu toString() třídy Person tak, aby vracela popis ve formátu:
- pro zaměstnance: Karel Dvořák (ID: 876)
- pro ostatní: Návštěva: Ivan Kratochvíl

-Připrav metodu, která vrátí osoby s počtem ticketů v zadaném rozmezí, které jsou dnes v práci (datum posledního příchodu je dnešní). Metoda dostane dva parametry — minimální a maximální počet ticketů.

-Připrav metodu pro výpis osob, které přišly do firmy naposledy minulý měsíc.

-Připrav metodu, která vrátí seznam všech osob, které mají zadané křestní jméno.
Například abychom zjistili, kdo má dnes svátek — pokud máme seznam svátků podle kalendáře.
﻿

Úkoly 3

-Připrav metodu, která vrátí seznam osob a u každé počet ticketů ve formátu:
Anna Dvořáková (14 ticketů)

-Speciálně pro některé počty ticketů výpis upraví:

- 0 ticketů: Adam Janák (bez ticketů)

- 1 ticket: Eva Malá (první ticket)

- 12 ticketů: Ivana Dvanáctá (první tucet ticketů)

- přes 30 ticketů: Jan Karas (zkušený zlepšovatel)

**Výzva jen pro zdatné**

-Připrav metodu, která vrátí zadaný počet osoby s největším počtem ticketů. Jako parametr dostane počet osob, které má vrátit.

Promysli, jestli by se vyplatilo osoby nejprve seřadit. Zároveň si všimni, jak moc by se zjednodušil kód. Řazení se naučíme v dalších lekcích. 