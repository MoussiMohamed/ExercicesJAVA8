# Rite de passage du padawan Front

## Préambule

Vous serez avant tout jugez sur votre coding style, votre rigueur et votre capacité à produire du beau code.
En parlant de beau, vous être libre d'utiliser un framework css afin d'embellir votre oeuvre.
Vous êtes totalement libre sur l'UX.
L'application devra être responsive.

## VueJS

Une application VueJS a été installée au préallable afin de vous aider à commencer le test. Cependant, libre à vous de changer de framework.
L'application est dans le dossier app/.
Vous pouvez lancer l'application via `npm run dev` dans le dossier app/.

## JSON Server

Ce test utilise `json-server` pour simuler une api REST.
https://github.com/typicode/json-server
La db est stockée dans une fichier json `db.json`;

Lancez l'api REST avec la commande `npm run server`.

## Les épreuves

### Epreuve 1

Votre première épreuve consistera à afficher dans l'application VueJS, la vente déjà créée ainsi que ses lots.

### Epreuve 2

Après avoir affiché la vente. Votre application devra capable de créer une vente avec des lots et de les persister dans le fichier `db.json`.

### Epreuve 3

Créer une nouvelle vue, dans laquelle on pourra rechercher parmis les ventes et les lots avec un seul champs `input`.
Cet unique champs de recherche sera capable de trouver des ventes et des lots, à vous de trouver un moyen de les distinguer dans les résultats.

### Bonus

- S'assurer de la compatibilité IE11
- Ajouter le konami code qui affiche un gif de votre choix