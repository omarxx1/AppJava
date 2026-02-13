#!/bin/bash
# Script per trasferire il progetto Java su GitHub da zero

# Spostati nella cartella del progetto
cd /mnt/c/Users/omars/..../Desktop/java-app1/app1  # esempio di percorso, modifica se necessario

# Rimuovi eventuale repository Git esistente
rm -rf .git

# Inizializza un nuovo repository Git
git init

# Rinominare la branch principale in main
git branch -M main

# Aggiungere tutti i file
git add .

# Primo commit
git commit -m "Primo commit del progetto Java senza segreti"

# Configurare il remote GitHub (modifica l'URL se serve)
git remote add origin https://github.com/omarxx1/AppJava.git

# Fare il push sul repository remoto
git push -u origin main
