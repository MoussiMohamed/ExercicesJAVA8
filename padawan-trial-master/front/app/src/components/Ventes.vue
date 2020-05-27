<template>
  <v-app>
    <div align="center">
      <v-data-table :headers="headers" :items="ventes" sort-by="title" class="elevation-1">
        <template v-slot:top>
          <v-toolbar flat color="white">
            <v-toolbar-title>Liste des ventes</v-toolbar-title>
            <v-divider class="mx-4" inset vertical></v-divider>
            <v-spacer></v-spacer>
            <v-dialog v-model="dialog" max-width="500px">
              <template v-slot:activator="{ on }">
                <v-btn color="primary" dark class="mb-2" v-on="on">Nouvelle Vente</v-btn>
              </template>
              <v-card>
                <v-card-title>
                  <span class="headline">Ajouter une nouvelle vente</span>
                </v-card-title>

                <v-card-text>
                  <v-container>
                    <v-row>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="nouvelleVente.title" label="Titre"></v-text-field>
                      </v-col>
                      <v-col cols="12" sm="6" md="4">
                        <v-text-field v-model="nouvelleVente.description" label="Description"></v-text-field>
                      </v-col>
                    </v-row>
                  </v-container>
                </v-card-text>

                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn color="blue darken-1" text @click="close">Annuler</v-btn>
                  <v-btn color="blue darken-1" text @click="creerVente">Ajouter</v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>
        <template v-slot:item.actions="{ item }">
          <router-link :to="{ name: 'lots', params: { sale_id: item.id, title: item.title }}">Voir Lots</router-link>
        </template>
        <template v-slot:no-data>
          <v-btn color="primary" @click="load">Actualiser</v-btn>
        </template>
      </v-data-table>
    </div>
  </v-app>
</template>

<script>
/* eslint-disable */
import axios from "axios";
import VenteService from "../services/VenteService";
import LotService from "../services/LotService";

export default {
  name: "Ventes",
  data() {
    return {
      msg: "Liste des ventes",
      headers: [
        {
          text: "Titre ",
          align: "start",
          sortable: false,
          value: "title"
        },
        { text: "Description", value: "description" },
        { text: "Actions", value: "actions", sortable: false }
      ],
      ventes: [],
      lots: [],
      form: {
        title: "",
        description: ""
      },
      errors: [],
      dialog: false,
      nouvelleVenteIndex: -1,
      nouvelleVente: {
        title: "",
        description: ""
      },
      nouvelleVenteParDefaut: {
        title: "",
        description: ""
      }
    };
  },

  watch: {
    dialog(val) {
      val || this.close();
    }
  },

  created() {
    this.load();
  },

  methods: {
    load() {
      VenteService.getAll()
        .then(response => {
          this.ventes = response.data;
        })
        .catch(err => {
          console.log(err);
        });

      LotService.getAll()
        .then(response => {
          this.lots = response.data;
        })
        .catch(err => {
          console.log(err);
        });
    },

    editItem(item) {
      this.nouvelleVenteIndex = this.ventes.indexOf(item);
      this.nouvelleVente = Object.assign({}, item);
      this.dialog = true;
    },

    deleteItem(item) {
      const index = this.ventes.indexOf(item);
      confirm("Are you sure you want to delete this item?") &&
        this.ventes.splice(index, 1);
    },

    close() {
      this.dialog = false;
      this.$nextTick(() => {
        this.nouvelleVente = Object.assign({}, this.nouvelleVenteParDefaut);
        this.nouvelleVenteIndex = -1;
      });
    },

    creerVente() {
      if (this.nouvelleVenteIndex > -1) {
        Object.assign(this.ventes[this.nouvelleVenteIndex], this.nouvelleVente);
      } else {
        VenteService.creerVente(this.nouvelleVente)
          .then(response => {
            this.load();
          })
          .catch(err => {
            console.log(err);
          });
      }
      this.close();
    }
  }
};
</script>
