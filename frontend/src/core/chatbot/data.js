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
    trigger: '6'
  },
  {
    id: '6',
    options: [
      { value: 'center', label: '1', trigger: '7' },
      { value: 'middle', label: '2', trigger: '7' },
      { value: 'not', label: '3+', trigger: '7' }
    ]
  },

  // {
  //   id: '3',
  //   message: 'Hi {previousValue}! What is your gender?',
  //   trigger: 'gender'
  // },

  {
    id: 'age',
    user: true,
    trigger: '7',
    validator: value => {
      if (isNaN(value)) {
        return 'value must be a number';
      } else if (value < 0) {
        return 'value must be positive';
      } else if (value > 120) {
        return `${value}? Come on!`;
      }

      return true;
    }
  },
  {
    id: '7',
    message: 'Great! Check out your summary',
    trigger: 'review'
  },
  {
    id: 'review',
    message: 'test',
    asMessage: true,
    trigger: 'update'
  },
  {
    id: 'update',
    message: 'Would you like to update some field?',
    trigger: 'update-question'
  },
  {
    id: 'update-question',
    options: [
      { value: 'yes', label: 'Yes', trigger: 'update-yes' },
      { value: 'no', label: 'No', trigger: 'end-message' }
    ]
  },
  {
    id: 'update-yes',
    message: 'What field would you like to update?',
    trigger: 'update-fields'
  },
  {
    id: 'update-fields',
    options: [
      { value: 'name', label: 'Name', trigger: 'update-name' },
      { value: 'gender', label: 'Gender', trigger: 'update-gender' },
      { value: 'age', label: 'Age', trigger: 'update-age' }
    ]
  },
  {
    id: 'update-name',
    update: 'name',
    trigger: '7'
  },
  {
    id: 'update-gender',
    update: 'gender',
    trigger: '7'
  },
  {
    id: 'update-age',
    update: 'age',
    trigger: '7'
  },
  {
    id: 'end-message',
    message: 'Thanks! Your data was submitted successfully!',
    end: true
  }
];

export default chatbotData;
