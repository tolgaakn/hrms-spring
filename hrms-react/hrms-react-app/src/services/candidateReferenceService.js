import axios from "axios";

export default class CandidateReferenceService{
    getByCurriculumVitae(curriculumVitaeId){
        return axios.get("http://localhost:8080/api/candidateReferences/getByCurriculumVitae?curriculumVitaeId=" + curriculumVitaeId);
    }
}