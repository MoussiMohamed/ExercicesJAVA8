/* eslint-disable */
import axios from 'axios'

const url = `${process.env.ROOT_API}/sales`;

class VenteService {
    /**
     * Récupération des ventes
     */
    getAll() {
        return axios.get(url);
    }
    /**
     * Méthode permet d'ajouter une vente
     * @param data Les données de formulaire d'ajout d'une vente 
     */
    create(data) {
        return axios.post(url, data);
    }
}

export default new VenteService();
