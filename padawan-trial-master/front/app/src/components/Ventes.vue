<template>
<v-app>
  <div align="center">
    <!-- <form @submit="add" 
          class="form">
      <p v-if="errors.length">
    <b>Veuillez corriger les erreurs suivante(s):</b>
    <ul>
      <li v-for="error in errors" 
          v-bind:key="error">{{ error }}</li>
    </ul>
  </p>
      <input type="text" 
             v-model="form.title" 
             placeholder="Titre" />
      <input type="text" 
             v-model="form.description" 
             placeholder="description" />

      <v-btn type="submit">Ajouter</v-btn>
    </form>
    <h1>Liste des Ventes</h1>
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Titre</th>
        <th>Description</th>
      </tr>
      <tr v-for="vente in ventes" 
          :key="vente.id">
        <td>
          <span>{{vente.id}}</span>
        </td>
        <td>
          <span>{{vente.title}}</span>
        </td>
        <td>
          <span>{{vente.description}}</span>
        </td>
        <td>
          <router-link :to="{ name: 'lots', params: { sale_id: vente.id }}">Lots</router-link>
        </td>
      </tr>
    </table> -->
  <!-- <v-data-table
    :headers="headers"
    :items="lots"
    item-key="description"
    group-by="sale_id"
    class="elevation-1"
    show-group-by
  ></v-data-table> -->
  <v-data-table
    :headers="headers"
    :items="ventes"
    sort-by="title"
    class="elevation-1"
  >
    <template v-slot:top>
      <v-toolbar flat color="white">
        <v-toolbar-title>My CRUD</v-toolbar-title>
        <v-divider
          class="mx-4"
          inset
          vertical
        ></v-divider>
        <v-spacer></v-spacer>
        <v-dialog v-model="dialog" max-width="500px">
          <template v-slot:activator="{ on }">
            <v-btn color="primary" dark class="mb-2" v-on="on">New Item</v-btn>
          </template>
          <v-card>
            <v-card-title>
              <span class="headline">{{ formTitle }}</span>
            </v-card-title>

            <v-card-text>
              <v-container>
                <v-row>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.title" label="Titre"></v-text-field>
                  </v-col>
                  <v-col cols="12" sm="6" md="4">
                    <v-text-field v-model="editedItem.description" label="Description"></v-text-field>
                  </v-col>
                </v-row>
              </v-container>
            </v-card-text>

            <v-card-actions>
              <v-spacer></v-spacer>
              <v-btn color="blue darken-1" text @click="close">Cancel</v-btn>
              <v-btn color="blue darken-1" text @click="save">Save</v-btn>
            </v-card-actions>
          </v-card>
        </v-dialog>
      </v-toolbar>
    </template>
    <template v-slot:item.actions="{ item }">
      <v-icon
        small
        class="mr-2"
        @click="editItem(item)"
      >
        mdi-pencil
      </v-icon>
      <v-icon
        small
        @click="deleteItem(item)"
      >
        mdi-delete
      </v-icon>
    </template>
    <template v-slot:no-data>
      <v-btn color="primary" @click="load">Reset</v-btn>
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
          text: 'Ventes ',
          align: 'start',
          sortable: false,
          value: 'title',
        },
        { text: 'Description', value: 'description' },
        { text: 'Actions', value: 'actions', sortable: false },
      ],
      ventes: [],
      lots: [],
      form: {
        title: "",
        description: ""
      },
      errors: [],
      dialog: false,
      editedIndex: -1,
      editedItem: {
        title: '',
        description: ''
      },
      defaultItem: {
        title: '',
        description: ''
      },
    };
  },
  // mounted() {
  //   this.load();
  // },

  computed: {
    formTitle () {
      return this.editedIndex === -1 ? 'New Item' : 'Edit Item'
    },
  },

  watch: {
    dialog (val) {
      val || this.close()
    },
  },

  created () {
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
    
    add() {
      // Validation && submit from
      if (this.form.title && this.form.description) {
        this.errors.length = 0;
        VenteService.create(this.form)
        .then(response => {
          this.load();
          this.form.title = "";
          this.form.description = "";
        })
        .catch(err => {
          console.log(err);
        });
      }
      
      else {
        if (!this.form.title) {
          this.errors.push('Titre requis.');
        }
        if (!this.form.description) {
          this.errors.push('Description requise.');
        }
      }
    },

    editItem (item) {
        this.editedIndex = this.ventes.indexOf(item)
        this.editedItem = Object.assign({}, item)
        this.dialog = true
      },

      deleteItem (item) {
        const index = this.ventes.indexOf(item)
        confirm('Are you sure you want to delete this item?') && this.ventes.splice(index, 1)
      },

      close () {
        this.dialog = false
        this.$nextTick(() => {
          this.editedItem = Object.assign({}, this.defaultItem)
          this.editedIndex = -1
        })
      },

      save () {
        if (this.editedIndex > -1) {
          Object.assign(this.ventes[this.editedIndex], this.editedItem)
        } else {
          this.ventes.push(this.editedItem)
        }
        this.close()
      },
  }
};
</script>
