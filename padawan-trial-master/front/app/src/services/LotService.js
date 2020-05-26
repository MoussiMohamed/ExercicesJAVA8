/* eslint-disable */
import axios from 'axios'

const url = `${process.env.ROOT_API}/items`;

class LotService {
    /**
    * Récupération de la liste des lots par vente
    */
    findBySaleId(sale_id) {
        return axios.get(`${url}?sale_id=${sale_id}`);
    }
    /**
    * Récupération des lots
    */
   getAll() {
        return axios.get(url);
    }
}

export default new LotService();
