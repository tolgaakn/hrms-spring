import React from 'react'
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
                    <Menu.Item header>Project Name</Menu.Item>
                    <Menu.Item as='a'>Blog</Menu.Item>
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
