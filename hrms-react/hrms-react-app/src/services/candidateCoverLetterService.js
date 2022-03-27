import axios from "axios";

export default class candidateCoverLetterService{
    getByCandidate(candidateId){
        return axios.get("http://localhost:8080/api/candidateCoverLetters/getByCandidateId?candidateId=" + candidateId);
    }
}