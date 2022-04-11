import React, { useState, useEffect } from 'react'
import { useParams } from "react-router-dom";
import { Button, Card, Container, Grid, GridColumn, Header, Icon, Label } from 'semantic-ui-react';
import JobAdvertisementService from "../../services/jobAdvertisementService";

export default function JobAdvertisementDetail() {
  let { id } = useParams();

  const [jobAdvertisement, setJobAdvertisement] = useState({});

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService
      .getJobAdvertisementDetailsById(id)
      .then((result) => setJobAdvertisement(result.data.data));
  }, []);

  return (
    <div className='mt-5 mb-5'>
      <Container>
        <Grid>
          <GridColumn>
            <Card fluid className='p-4'>
              <Grid>
                <GridColumn width={4}><Header>{jobAdvertisement.position} İlanı</Header></GridColumn>
                <GridColumn width={8}></GridColumn>
                <GridColumn width={4}>
                  <Label title='Açık Pozisyon' className='align-middle'>
                    <Icon name='group' /> {jobAdvertisement.openPosition}
                  </Label>
                  <Button
                    floated='right'
                    color='red'
                    icon='heart'
                    content='Favorilere Ekle'
                  />
                </GridColumn>
              </Grid>
              <Grid>
                <GridColumn width={10}>
                  <p className='text-left'>{jobAdvertisement.jobDescription}</p>
                </GridColumn>
                <GridColumn width={2}></GridColumn>
                <GridColumn width={4} textAlign='left' className=''>
                  <Grid>
                    <GridColumn>
                      <span>Son Başvuru Tarihi : {jobAdvertisement.applicationDeadline}</span>
                    </GridColumn>
                  </Grid>
                  <Grid>
                    <GridColumn>
                      <span>Maaş Aralığı : {jobAdvertisement.minSalary} - {jobAdvertisement.maxSalary}</span>
                    </GridColumn>
                  </Grid>
                </GridColumn>
              </Grid>
              <Grid>
                <GridColumn width={6} className='m-auto'><Button fluid color='green'>Green</Button></GridColumn>
              </Grid>
            </Card>
          </GridColumn>
        </Grid>
      </Container>

    </div>
  )
}
