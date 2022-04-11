import React, { useEffect, useState } from 'react'
import { Button, Card, Container, Dropdown, Form, Grid, Header } from 'semantic-ui-react'
import { Formik, useFormik } from 'formik';
import * as Yup from 'yup';
import JobPositionService from "../../services/jobPositionService";
import CityService from "../../services/cityService";
import JobTypeService from "../../services/jobTypeService";
import WorkTypeService from "../../services/workTypeService";
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import DatePicker from "react-datepicker";

import "react-datepicker/dist/react-datepicker.css";
import JobAdvertisementService from '../../services/jobAdvertisementService';

export default function AddJobAdvertisement() {

    const [jobPositions, setJobPositions] = useState([]);
    const [cities, setCities] = useState([]);
    const [jobTypes, setJobTypes] = useState([]);
    const [workTypes, setWorkTypes] = useState([]);

    const [startDate, setStartDate] = useState(new Date());

    let jobPositionService = new JobPositionService();
    let cityService = new CityService();
    let jobTypeService = new JobTypeService();
    let workTypeService = new WorkTypeService();

    let jobAdvertisementService = new JobAdvertisementService();

    useEffect(() => {
        jobPositionService.getJobPositions().then(result => setJobPositions(result.data.data));
        cityService.getCities().then(result => setCities(result.data.data));
        jobTypeService.getJobTypes().then(result => setJobTypes(result.data.data));
        workTypeService.getWorkTypes().then(result => setWorkTypes(result.data.data));
    }, []);

    const jobPositionOptions = jobPositions.map((jobPosition) => ({
        key: jobPosition.id,
        text: jobPosition.title,
        value: jobPosition.id
    }));

    const cityOptions = cities.map((city) => ({
        key: city.id,
        text: city.name,
        value: city.id
    }));

    const jobTypeOptions = jobTypes.map((jobType) => ({
        key: jobType.id,
        text: jobType.jobTypeName,
        value: jobType.id
    }));

    const workTypeOptions = workTypes.map((workType) => ({
        key: workType.id,
        text: workType.workTypeName,
        value: workType.id
    }));

    const formik = useFormik({
        initialValues: {
            openPosition: "",
            minSalary: "",
            maxSalary: "",
            jobDescription: ""
        },
        validationSchema: Yup.object({
            jobPosition: Yup.string().required(),
            city: Yup.string().required(),
            jobType: Yup.string().required(),
            workType: Yup.string().required(),
            openPosition: Yup.number().required(),
            minSalary: Yup.number().required(),
            maxSalary: Yup.number().required(),
            jobDescription: Yup.string().required(),
        }),
        handleChange: (fieldName, value) => {
            formik.setFieldValue(fieldName, value);
        },
        onSubmit: values => {
            console.log('Form Data', values)
        }
    });

    return (
        <div>
            <Container className='mt-5 mb-5'>
                <Grid>
                    <Grid.Row>
                        <Header as='h3' dividing className='text-left'>
                            İş İlanı Oluştur
                        </Header>
                    </Grid.Row>
                    <Grid.Row>
                        <Card fluid style={{ padding: "1em" }}>
                            <Formik value={formik.onSubmit}>
                                <Form onSubmit={formik.handleSubmit}>
                                    <Card.Content>
                                        <div className='row mb-2'>
                                            <div className='col-md-6'>
                                                <Dropdown
                                                    name='jobPosition'
                                                    id={jobPositionOptions.id}
                                                    placeholder='İş Pozisyonu'
                                                    search selection fluid
                                                    options={jobPositionOptions}
                                                    onChange={(event, data) => formik.handleChange("jobTitle", data.value)}
                                                    error={formik.errors.jobPosition && true}
                                                    value={formik.values.jobPosition} />

                                            </div>
                                            <div className='col-md-6'>
                                                <Dropdown
                                                    name='city'
                                                    placeholder='Şehir'
                                                    search selection fluid
                                                    options={cityOptions}
                                                    onChange={(event, data) => formik.handleChange("jobTitle", data.value)}
                                                    error={formik.errors.city && true}
                                                    value={formik.values.city} />
                                            </div>
                                        </div>
                                        <div className='row mb-3'>
                                            <div className='col-md-6'>
                                                <div className="row">
                                                    <div className='col-md-6'>
                                                        <Dropdown
                                                            name='jobType'
                                                            placeholder='İş Türü'
                                                            search selection fluid
                                                            options={jobTypeOptions}
                                                            onChange={(event, data) => formik.handleChange("jobTitle", data.value)}
                                                            error={formik.errors.jobType && true}
                                                            value={formik.values.jobType} />
                                                    </div>
                                                    <div className='col-md-6'>
                                                        <Dropdown
                                                            name='workType'
                                                            placeholder='Çalışma Türü'
                                                            search selection fluid
                                                            options={workTypeOptions}
                                                            onChange={(event, data) => formik.handleChange("jobTitle", data.value)}
                                                            error={formik.errors.workType && true}
                                                            value={formik.values.workType} />
                                                    </div>
                                                </div>
                                            </div>
                                            <div className='col-md-6'>
                                                <Form.Input
                                                    type='number'
                                                    placeholder="Açık Pozisyon"
                                                    name='openPosition'
                                                    onChange={formik.handleChange}
                                                    error={formik.errors.openPosition && true}
                                                    value={formik.values.openPosition} />
                                            </div>
                                        </div>
                                        <div className="row mb-3">
                                            <div className="col-md-6">
                                                <div className="row">
                                                    <div className="col-md-6">
                                                        <Form.Input
                                                            type='number'
                                                            placeholder="Min. Maaş"
                                                            name='minSalary'
                                                            onChange={formik.handleChange}
                                                            error={formik.errors.minSalary && true}
                                                            value={formik.values.minSalary} />
                                                    </div>
                                                    <div className="col-md-6">
                                                        <Form.Input
                                                            type='number'
                                                            placeholder="Maks. Maaş"
                                                            name='maxSalary'
                                                            onChange={formik.handleChange}
                                                            error={formik.errors.maxSalary && true}
                                                            value={formik.values.maxSalary} />
                                                    </div>
                                                </div>
                                            </div>
                                            <div className="col-md-6">
                                                <DatePicker
                                                    name='lastDate'
                                                    placeholder='Son Başvuru Tarihi'
                                                    selected={startDate}
                                                    onChange={(date) => setStartDate(date)}
                                                    error={formik.errors.lastDate && true}
                                                    value={formik.values.lastDate} />
                                            </div>
                                        </div>
                                        <div className='row mb-4'>
                                            <div className="col-md-12">
                                                <CKEditor
                                                    editor={ClassicEditor}
                                                    name="jobDescription"
                                                    data="<p>Hello from CKEditor 5!</p>"
                                                    onReady={editor => {
                                                        // You can store the "editor" and use when it is needed.
                                                        console.log('Editor is ready to use!', editor);
                                                    }}
                                                    onChange={(event, editor) => {
                                                        const data = editor.getData();
                                                        console.log({ event, editor, data });
                                                    }}
                                                    onBlur={(event, editor) => {
                                                        console.log('Blur.', editor);
                                                    }}
                                                    onFocus={(event, editor) => {
                                                        console.log('Focus.', editor);
                                                    }}
                                                    error={formik.errors.jobDescription && true}
                                                    value={formik.values.jobDescription}
                                                />
                                            </div>
                                        </div>
                                        <Button type='submit'>İlan Oluştur</Button>
                                    </Card.Content>
                                </Form>
                            </Formik>
                        </Card>
                    </Grid.Row>
                </Grid>
            </Container>
        </div>
    )
}
