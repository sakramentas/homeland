const chatbotData = [
  {
    id: '1',
    message: 'Hey there',
    trigger: '2'
  },
  {
    id: '2',
    message: 'Nice to meet you',
    trigger: '3'
  },
  {
    id: '3',
    message: 'Lets find your new Home!',
    trigger: '4'
  },
  {
    id: '4',
    message: 'Where would you like to live?',
    trigger: 'city'
  },
  {
    id: 'city',
    options: [
      { value: 'center', label: 'City center', trigger: '5' },
      { value: 'middle', label: 'Suburbs', trigger: '5' },
      { value: 'not', label: 'Rural', trigger: '5' }
    ]
  },

  {
    id: '5',
    message: 'How many is in your family?',
    trigger: 'family'
  },
  {
    id: 'family',
    options: [
      { value: 'center', label: '1', trigger: '6' },
      { value: 'middle', label: '2', trigger: '6' },
      { value: 'not', label: '3+', trigger: '6' }
    ]
  },

  {
    id: '6',
    message: 'What type of property are you after?',
    trigger: 'home'
  },

  {
    id: 'home',
    options: [
      { value: 'center', label: 'House', trigger: '7' },
      { value: 'middle', label: 'Apartment', trigger: '7' },
      { value: 'not', label: 'Flat', trigger: '7' }
    ]
  },

  {
    id: '7',
    message: 'Is this your first time buying a home?',
    trigger: 'firstTime'
  },

  {
    id: 'firstTime',
    options: [
      { value: 'center', label: 'Yes', trigger: '8' },
      { value: 'middle', label: 'No', trigger: '8' }
    ]
  },

  {
    id: '8',
    message: 'Are you purchasing with someone else?',
    trigger: 'joint'
  },

  {
    id: 'joint',
    options: [
      { value: 'center', label: 'Yes', trigger: 'sub-end-message' },
      { value: 'middle', label: 'No', trigger: 'sub-end-message' }
    ]
  },

  {
    id: 'sub-end-message',
    message: 'Everything looks great!',
    trigger: 'end-message'
  },

  {
    id: 'end-message',
    message: 'Let us compile the information and find the right Home for you!',
    end: true
  }
];

export default chatbotData;
