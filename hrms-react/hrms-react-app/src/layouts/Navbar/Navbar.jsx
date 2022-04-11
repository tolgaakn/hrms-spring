import React from 'react'
import { Link } from 'react-router-dom'
import { Container, Dropdown, Image, Menu } from 'semantic-ui-react'

export default function Navbar() {
    return (
        <div>
            <Menu
                borderless
            >
                <Container text>
                    <Menu.Item>
                        <Image size='mini' src='/logo.png' />
                    </Menu.Item>
                    <Menu.Item header><Link to={`/`}>Ana Sayfa</Link></Menu.Item>
                    <Menu.Item as='a'><Link to={`/job-advertisements`}>İş İlanları</Link></Menu.Item>
                    <Menu.Item as='a'>Articles</Menu.Item>

                    <Menu.Menu position='right'>
                        <Dropdown text='Dropdown' pointing className='link item'>
                            <Dropdown.Menu>
                                <Dropdown.Item>List Item</Dropdown.Item>
                                <Dropdown.Item>List Item</Dropdown.Item>
                                <Dropdown.Divider />
                                <Dropdown.Header>Header Item</Dropdown.Header>
                                <Dropdown.Item>
                                    <i className='dropdown icon' />
                                    <span className='text'>Submenu</span>
                                    <Dropdown.Menu>
                                        <Dropdown.Item>List Item</Dropdown.Item>
                                        <Dropdown.Item>List Item</Dropdown.Item>
                                    </Dropdown.Menu>
                                </Dropdown.Item>
                                <Dropdown.Item>List Item</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </Menu.Menu>
                </Container>
            </Menu>
        </div>
    )
}
