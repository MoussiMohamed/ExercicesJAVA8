<template>
<div align="center">
    <h1>Liste des Lots</h1>
    param {{sale_id}}
    <table border="1">
        <tr>
          <th>ID</th>
          <th>Description</th>
        </tr>
        <tr v-for="lot in items" :key="lot.id">
          <td><span>{{lot.id}}</span> &#160;</td>
          <td><span>{{lot.description}}</span> &#160;</td>
        </tr>
      </table>
</div>
</template>

<script>
/* eslint-disable */ 
import axios from 'axios'
export default {
  name: 'Lots',
  data () {
    return {
      msg: 'Liste des Lots',
      items: [],
      sale_id: ''
    }
  },
  mounted() {
    this.load()
  },
  created() {
      this.sale_id = this.$route.params.sale_id;
  },
  methods: {
    load(){
        axios.get('http://localhost:3000/items?sale_id='+this.sale_id).then(res => {
            this.items = res.data
        }).catch ((err) => {
            console.log(err);
        })
    }
  }
}
</script>
