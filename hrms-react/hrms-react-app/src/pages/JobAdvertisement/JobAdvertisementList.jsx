import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import { Card, CardBody } from 'reactstrap';
import { Button, ButtonGroup, Container, Grid, GridColumn, Header, Icon, Image, Label } from 'semantic-ui-react';
import Filter from '../../layouts/Filter/Filter';
import JobAdvertisementService from "../../services/jobAdvertisementService";
import './JobAdvertisement.css';

export default function JobAdvertisementList() {
    const [jobAdvertisements, setJobAdvertisements] = useState([]);

    useEffect(() => {
        let jobAdvertisementService = new JobAdvertisementService();
        jobAdvertisementService.getByActive().then(result => setJobAdvertisements(result.data.data));
    });

    return (
        <div className='mt-5 mb-5'>
            <Container>
                <Grid>
                    <GridColumn width={4}></GridColumn>
                    <GridColumn width={12}>
                        <Header as='h3' dividing className='text-left'>
                            İş İlanları
                        </Header>
                    </GridColumn>
                </Grid>
                <Grid>
                    <GridColumn width={4}>
                        <Filter></Filter>
                    </GridColumn>
                    <GridColumn width={12}>
                        {jobAdvertisements.map((jobAdvertisement) => (
                            <Card className='mb-4 advertisement-card' key={jobAdvertisement.id}>
                                <Link to={`/job-advertisements/${jobAdvertisement.id}`}>
                                    <CardBody>
                                        <Grid>
                                            <GridColumn width={3}>
                                                <Image
                                                    src='/images/image.png'
                                                    size='small'
                                                    wrapped
                                                />
                                            </GridColumn>
                                            <GridColumn width={8}>
                                                <Header
                                                    as='h3'
                                                    content={jobAdvertisement.jobPosition.title}
                                                    subheader='Firma Adı'
                                                    className='text-left'
                                                />
                                                <Label title='Başvuran Aday'>
                                                    <Icon name='group' /> 23
                                                </Label>
                                                <Header
                                                    as='h5'
                                                    content={'Son Başvuru : ' + jobAdvertisement.lastDate}
                                                    disabled
                                                    floated='left'
                                                />
                                            </GridColumn>
                                            <GridColumn width={5}>
                                                <ButtonGroup className='advertisement-buttons' key={jobAdvertisement.id}>
                                                    <Button
                                                        color='red'
                                                        icon='heart'
                                                    />
                                                    <Button animated color='blue' key={jobAdvertisement.id}>
                                                        <Button.Content visible>İlana Başvur</Button.Content>
                                                        <Button.Content hidden>
                                                            <Icon name='arrow right' />
                                                        </Button.Content>
                                                    </Button>
                                                </ButtonGroup>
                                            </GridColumn>
                                        </Grid>
                                    </CardBody>
                                </Link>
                            </Card>
                        ))}
                    </GridColumn>
                </Grid>
            </Container>
        </div>
    )
}
