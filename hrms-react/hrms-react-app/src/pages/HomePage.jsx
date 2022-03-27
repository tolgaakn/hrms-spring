import React from 'react'
import { Image, Input } from 'semantic-ui-react'
import '../assets/css/HomePage/HomePage.css';

export default function HomePage() {
  return (
    <div>
      <Image src='/images/homepage.jpg' fluid />
      <Input icon='search' placeholder='Search...' className='homepage-search' />
    </div>
  )
}
